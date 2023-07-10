package com.simform.assignment.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
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