package com.simform.assignment.dto;

import com.simform.assignment.entity.Order;
import com.simform.assignment.entity.Product;
import com.simform.assignment.entity.User;
import lombok.Data;

import java.util.List;

/**
 * DTO for {@link Order}
 */
@Data
public class CreateRequestOrderDto {
  UserDto user;
  List<ProductDto> products;
}