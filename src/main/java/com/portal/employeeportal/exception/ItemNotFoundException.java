package com.portal.employeeportal.exception;

public class ItemNotFoundException extends RuntimeException {

  private final String message;

  public ItemNotFoundException(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return this.message;
  }

  @Override
  public String getMessage() {
    return message;
  }

}
