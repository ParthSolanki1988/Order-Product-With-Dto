package com.simform.assignment.mapstructmapping;

import com.simform.assignment.dto.order.CreateRequestOrderDto;
import com.simform.assignment.dto.order.CreateResponseOrderDto;
import com.simform.assignment.dto.product.CreateResponseProductDto;
import com.simform.assignment.dto.product.ProductDto;
import com.simform.assignment.dto.user.CreateResponseUserDto;
import com.simform.assignment.dto.user.UserDto;
import com.simform.assignment.entity.Order;
import com.simform.assignment.entity.Product;
import com.simform.assignment.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapping {

  CreateRequestOrderDto toDto(Order order);

  CreateResponseOrderDto toResponseDto(Order order);

  Order toOrder(CreateRequestOrderDto createRequestOrderDto);

  UserDto userToUserDto(User user);

  User userDtoToUser(UserDto userDto);

  ProductDto productToProductDto(Product product);

  CreateResponseUserDto userToResponseUserDto(User user);

  CreateResponseProductDto productToResponseProductDto(Product product);
  Product productDtoToProduct(ProductDto productDto);

  List<ProductDto> productListToProductDtoList(List<Product> list);

  List<Product> productDtoListToProductList(List<ProductDto> list);

  CreateResponseOrderDto orderToDto(Order order);
}
