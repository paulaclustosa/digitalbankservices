package com.letscode.user.dto;

import lombok.Getter;

@Getter
public class ValidateUserCredentialsRequest {
  private String cpf;
  private String loginPassword;
}
