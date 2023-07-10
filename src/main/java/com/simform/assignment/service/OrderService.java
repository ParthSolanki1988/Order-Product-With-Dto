package com.simform.assignment.service;

import com.simform.assignment.dto.order.CreateRequestOrderDto;
import com.simform.assignment.dto.order.CreateResponseOrderDto;
import com.simform.assignment.entity.Order;
import com.simform.assignment.exception.NotFoundException;
import com.simform.assignment.mapstructmapping.MapStructMapping;
import com.simform.assignment.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MapStructMapping mapStructMapping;

    public void create(Order order) {

    }

//    public List<Order> getAll() {
//        List<Order> orderList = orderRepository.findAll();
//        if (orderList.size() == 0) {
////            throw new NotFoundException();
//        } else {
//            return orderList;
//        }
//    }
    public CreateResponseOrderDto updateOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        Optional<CreateRequestOrderDto> createRequestOrderDto = optionalOrder.map(mapStructMapping::toDto);
        if(createRequestOrderDto.isEmpty()) {
            throw new NotFoundException("Order Not Found");
        } else {
            Order order = mapStructMapping.toOrder(createRequestOrderDto.get());
            Order saveOrder = orderRepository.save(order);
            return mapStructMapping.toResponseDto(saveOrder);
        }
    }

    public CreateResponseOrderDto createOrder(CreateRequestOrderDto createRequestOrderDto) {
        Order order = mapStructMapping.toOrder(createRequestOrderDto);
        Order save = orderRepository.save(order);
        return mapStructMapping.toResponseDto(save);
    }

    public List<CreateResponseOrderDto> getAllUser() {

        List<CreateResponseOrderDto> listOfOrderResponseDto = orderRepository.findAll().stream().map(mapStructMapping::orderToDto).collect(Collectors.toList());
        if (listOfOrderResponseDto.size() == 0){
            throw  new NotFoundException("List is Empty");
        }
        else {
            return listOfOrderResponseDto;
        }
    }
}
