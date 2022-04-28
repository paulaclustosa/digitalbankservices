package com.letscode.account.client.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateCustomerRequest {
  private String cpf;
  private String firstName;
  private String lastName;
  private Integer loginPassword;
}
