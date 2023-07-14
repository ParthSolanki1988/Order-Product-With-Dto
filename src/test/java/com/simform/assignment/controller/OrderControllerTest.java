package com.simform.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simform.assignment.dto.order.CreateRequestOrderDto;
import com.simform.assignment.dto.order.CreateResponseOrderDto;
import com.simform.assignment.dto.product.ProductDto;
import com.simform.assignment.dto.user.UserDto;
import com.simform.assignment.entity.Order;
import com.simform.assignment.mapstructmapping.MapStructMapping;
import com.simform.assignment.mapstructmapping.MapStructMappingImpl;
import com.simform.assignment.service.OrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@Import(OrderController.class)
@ContextConfiguration(classes = MapStructMappingImpl.class)
class OrderControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  MapStructMapping mapStructMapping;

  @MockBean
  OrderService orderService;

  CreateRequestOrderDto createRequestOrderDto;
  CreateResponseOrderDto createResponseOrderDto;
  UserDto userDto;
  ProductDto productDto,productDto2;

  List<ProductDto> productDtoList = new ArrayList<>();


  @BeforeEach
  void setUp() {
    userDto = new UserDto("Parth" , "Rajkot" , "9327049319");
    productDto = new ProductDto("Laptop");
    productDto2 = new ProductDto("Car");
    productDtoList.add(productDto);
    productDtoList.add(productDto2);
   createRequestOrderDto = new CreateRequestOrderDto(userDto , productDtoList);
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void createOrder() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    String requestDto = objectMapper.writeValueAsString(createRequestOrderDto);
    System.out.println(requestDto);

    Order order = mapStructMapping.toOrder(createRequestOrderDto);
    createResponseOrderDto = mapStructMapping.orderToDto(order);

    when(orderService.createOrder(createRequestOrderDto)).thenReturn(createResponseOrderDto);

    MvcResult result = this.mockMvc.perform(post("/api/v1/orderbook")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestDto))
            .andDo(print())
            .andExpect(status().isCreated()).andReturn();
    System.out.println(result);

    String contentAsString = result.getResponse().getContentAsString();
    assertThat(contentAsString).isEqualTo(requestDto);
  }

  @Test
  void getAll() {
  }
}