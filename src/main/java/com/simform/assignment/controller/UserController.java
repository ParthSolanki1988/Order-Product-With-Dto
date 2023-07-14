package com.simform.assignment.controller;

import com.simform.assignment.dto.order.CreateResponseOrderDto;
import com.simform.assignment.dto.user.CreateRequestUserDto;
import com.simform.assignment.dto.user.CreateResponseUserDto;
import com.simform.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

  @Autowired
  UserService userService;


  @PostMapping
  public ResponseEntity<CreateResponseUserDto> createUser(@RequestBody CreateRequestUserDto createRequestUserDto){
    CreateResponseUserDto user = userService.createUser(createRequestUserDto);
    return new ResponseEntity<>(user , HttpStatus.CREATED);
  }

}
