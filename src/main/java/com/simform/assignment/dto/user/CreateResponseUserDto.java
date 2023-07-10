package com.simform.assignment.dto.user;

import lombok.Data;

/**
 * DTO for {@link com.simform.assignment.entity.User}
 */
@Data
public class CreateResponseUserDto {
  Long userId;
  String userName;
  String address;
  String phoneNumber;
}