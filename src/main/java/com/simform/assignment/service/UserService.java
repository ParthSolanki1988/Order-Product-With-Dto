package com.simform.assignment.service;

import com.simform.assignment.dto.user.CreateRequestUserDto;
import com.simform.assignment.dto.user.CreateResponseUserDto;
import com.simform.assignment.entity.User;
import com.simform.assignment.mapstructmapping.MapStructMapping;
import com.simform.assignment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  MapStructMapping mapStructMapping;

  public CreateResponseUserDto createUser(CreateRequestUserDto createRequestUserDto) {
    User user = mapStructMapping.createRequestUserDtoToUser(createRequestUserDto);
    User saveUser = userRepository.save(user);
    CreateResponseUserDto createResponseUserDto = mapStructMapping.userToResponseUserDto(saveUser);
    return createResponseUserDto;
  }
}
