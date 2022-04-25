package com.letscode.account.dto;

import com.letscode.account.annotation.AccountPassword;
import com.letscode.account.annotation.LoginPassword;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateAccountRequest {
  @CPF
  private String cpf;

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  private Integer branchNumber;

  @AccountPassword
  private Integer password;

  @LoginPassword
  private Integer loginPassword;
}
