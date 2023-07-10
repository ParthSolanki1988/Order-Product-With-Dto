package com.simform.assignment.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.simform.assignment.entity.Product}
 */
@Data
public class ProductDto {
  String productName;
}