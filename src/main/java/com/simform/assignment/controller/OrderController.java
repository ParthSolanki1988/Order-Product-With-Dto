package com.simform.assignment.controller;

import com.simform.assignment.dto.order.CreateRequestOrderDto;
import com.simform.assignment.dto.order.CreateResponseOrderDto;
import com.simform.assignment.mapstructmapping.MapStructMapping;
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
    @Autowired
    private MapStructMapping mapStructMapping;

    @PostMapping
    public ResponseEntity<CreateResponseOrderDto> createOrder(@RequestBody CreateRequestOrderDto createRequestOrderDto) {
        CreateResponseOrderDto order = orderService.createOrder(createRequestOrderDto);
        return new ResponseEntity<>(order , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CreateResponseOrderDto>> getAll() {
        List<CreateResponseOrderDto> allUser = orderService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<CreateResponseOrderDto> updateOrder(@PathVariable("id") Long id , CreateRequestOrderDto createRequestOrderDto){
        CreateResponseOrderDto orderDto = orderService.updateOrderById(id);
        return new ResponseEntity<>(orderDto , HttpStatus.FOUND);

    }
}
