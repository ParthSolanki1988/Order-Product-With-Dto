package com.simform.assignment.controller;

import com.simform.assignment.dto.product.CreateResponseProductDto;
import com.simform.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

  @Autowired
  ProductService productService;


  @GetMapping
  public ResponseEntity<List<CreateResponseProductDto>> getAllProducts(){
    List<CreateResponseProductDto> all = productService.getAll();
    return new ResponseEntity<>(all , HttpStatus.FOUND);
  }
}
