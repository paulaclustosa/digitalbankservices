package com.letscode.customer.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateCustomerResponse {
  private Integer id;
  private String cpf;
  private String fullName;

  @Builder
  public CreateCustomerResponse(Integer id, String cpf, String firstName, String lastName) {
    this.id = id;
    this.cpf = cpf;
    this.fullName = firstName + " " + lastName;
  }
}
