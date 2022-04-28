package com.letscode.customer.dto;

import com.letscode.customer.annotation.LoginPassword;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateCustomerRequest {
  @CPF
  private String cpf;
  @NotBlank
  private String firstName;
  @NotBlank
  private String lastName;
  @LoginPassword
  private Integer loginPassword;
}
