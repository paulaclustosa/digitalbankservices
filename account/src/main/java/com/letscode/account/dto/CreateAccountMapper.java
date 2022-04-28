package com.letscode.account.dto;

import com.letscode.account.model.Account;

import java.time.format.DateTimeFormatter;

public class CreateAccountMapper {

  private CreateAccountMapper() {
  }

  public static CreateAccountResponse toCreatedAccountResponse(Account account) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    return CreateAccountResponse.builder()
        .id(account.getId())
        .branchNumber(account.getBranchNumber())
        .number(account.getNumber())
        .balance(account.getBalance())
        .createdAt(account.getCreatedAt().format(formatter))
        .updatedAt(account.getUpdatedAt().format(formatter))
        .customerId(account.getCustomerId())
        .build();
  }

}
