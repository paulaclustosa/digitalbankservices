package com.letscode.account.client.dto;

import lombok.Builder;

@Builder
public class CreateUserRequest {
  private String cpf;
  private String firstName;
  private String lastName;
  private Integer loginPassword;
}
