package com.letscode.user.dto;

import com.letscode.user.annotation.LoginPassword;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateUserRequest {
  @CPF
  private String cpf;
  @NotBlank
  private String firstName;
  @NotBlank
  private String lastName;
  @LoginPassword
  private Integer loginPassword;
}
