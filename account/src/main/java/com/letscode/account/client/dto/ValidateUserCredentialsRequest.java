package com.letscode.account.client.dto;

import lombok.Builder;

@Builder
public class ValidateUserCredentialsRequest {
  private String cpf;
  private String loginPassword;
}
