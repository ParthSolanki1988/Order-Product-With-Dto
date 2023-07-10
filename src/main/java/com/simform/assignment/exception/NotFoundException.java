package com.simform.assignment.exception;

public class NotFoundException extends RuntimeException{

  public NotFoundException(String message) {
    System.out.println(message);
  }
}
