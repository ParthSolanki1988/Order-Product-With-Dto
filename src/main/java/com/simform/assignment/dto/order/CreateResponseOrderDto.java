package com.simform.assignment.dto.order;

import com.simform.assignment.dto.product.ProductDto;
import com.simform.assignment.dto.user.UserDto;
import lombok.Data;

import java.util.List;

/**
 * DTO for {@link com.simform.assignment.entity.Order}
 */
@Data
public class CreateResponseOrderDto {
  Long orderId;
  UserDto user;
  List<ProductDto> products;
}