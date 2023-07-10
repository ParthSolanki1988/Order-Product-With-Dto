package com.simform.assignment.mapstructmapping;

import com.simform.assignment.dto.CreateRequestOrderDto;
import com.simform.assignment.dto.CreateResponseOrderDto;
import com.simform.assignment.dto.ProductDto;
import com.simform.assignment.dto.UserDto;
import com.simform.assignment.entity.Order;
import com.simform.assignment.entity.Product;
import com.simform.assignment.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapping {

  CreateRequestOrderDto toDto(Order order);

  Order toOrder(CreateRequestOrderDto createRequestOrderDto);

  UserDto userToUserDto(User user);

  User userDtoToUser(UserDto userDto);

  ProductDto productToProductDto(Product product);

  Product productDtoToProduct(ProductDto productDto);

  List<ProductDto> productListToProductDtoList(List<Product> list);

  List<Product> productDtoListToProductList(List<ProductDto> list);

  CreateResponseOrderDto orderToDto(Order order);
}
