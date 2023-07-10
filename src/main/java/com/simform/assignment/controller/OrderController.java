package com.simform.assignment.controller;

import com.simform.assignment.dto.CreateRequestOrderDto;
import com.simform.assignment.dto.CreateResponseOrderDto;
import com.simform.assignment.entity.Order;
import com.simform.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<CreateRequestOrderDto> createOrder(@RequestBody CreateRequestOrderDto createRequestOrderDto) {
        CreateRequestOrderDto order = orderService.createOrder(createRequestOrderDto);
        return new ResponseEntity<>(order , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CreateResponseOrderDto>> getAll() {
        List<CreateResponseOrderDto> allUser = orderService.getAllUser();
//        List<Order> orderList = orderService.getAll();
        return new ResponseEntity<>(allUser, HttpStatus.FOUND);
    }
}
