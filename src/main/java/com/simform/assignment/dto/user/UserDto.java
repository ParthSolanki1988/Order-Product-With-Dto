package com.simform.assignment.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.simform.assignment.entity.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  String userName;
  String address;
  String phoneNumber;

}