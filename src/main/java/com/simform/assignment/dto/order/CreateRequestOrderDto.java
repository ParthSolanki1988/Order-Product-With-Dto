package com.simform.assignment.dto.order;

import com.simform.assignment.dto.product.ProductDto;
import com.simform.assignment.dto.user.UserDto;
import com.simform.assignment.entity.Order;
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