package com.simform.assignment.service;

import com.simform.assignment.dto.CreateRequestOrderDto;
import com.simform.assignment.dto.CreateResponseOrderDto;
import com.simform.assignment.entity.Order;
import com.simform.assignment.exception.OrderNotFoundException;
import com.simform.assignment.mapstructmapping.MapStructMapping;
import com.simform.assignment.repository.OderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OderRepository oderRepository;

    @Autowired
    MapStructMapping mapStructMapping;

    public void create(Order order) {

    }

    public List<Order> getAll() {
        List<Order> orderList = oderRepository.findAll();
        if (orderList.size() == 0) {
            throw new OrderNotFoundException();
        } else {
            return orderList;
        }
    }
    public Order getById(Long id) {
        Optional<Order> orderById = oderRepository.findById(id);
        if(orderById.isEmpty()) {
            throw new OrderNotFoundException();
        } else {
            return orderById.get();
        }
    }

    public CreateRequestOrderDto createOrder(CreateRequestOrderDto createRequestOrderDto) {
        Order order = mapStructMapping.toOrder(createRequestOrderDto);
        Order save = oderRepository.save(order);
        return mapStructMapping.toDto(save);
    }

    public List<CreateResponseOrderDto> getAllUser() {
        return oderRepository.findAll().stream().map(mapStructMapping::orderToDto).collect(Collectors.toList());
    }
}
