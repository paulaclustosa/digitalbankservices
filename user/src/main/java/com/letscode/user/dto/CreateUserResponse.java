package com.letscode.user.dto;

import lombok.Builder;

public class CreateUserResponse {
  private Integer id;
  private String cpf;
  private String fullName;

  @Builder
  public CreateUserResponse(Integer id, String cpf, String firstName, String lastName) {
    this.id = id;
    this.cpf = cpf;
    this.fullName = firstName + " " + lastName;
  }

}
