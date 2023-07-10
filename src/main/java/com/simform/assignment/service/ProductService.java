package com.simform.assignment.service;

import com.simform.assignment.dto.product.CreateResponseProductDto;
import com.simform.assignment.mapstructmapping.MapStructMapping;
import com.simform.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;
  @Autowired
  MapStructMapping mapStructMapping;

  public List<CreateResponseProductDto> getAll() {
    List<CreateResponseProductDto> collect = productRepository.findAll().stream().map(mapStructMapping::productToResponseProductDto).collect(Collectors.toList());
    return collect;
  }
}
