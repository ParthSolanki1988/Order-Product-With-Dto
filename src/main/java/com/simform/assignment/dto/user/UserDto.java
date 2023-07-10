package com.simform.assignment.dto.user;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.simform.assignment.entity.User}
 */
@Data
public class UserDto {
  String userName;
  String address;
  String phoneNumber;
}