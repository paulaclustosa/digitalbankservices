package com.letscode.account.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class CreateAccountResponse {
  private Integer id;
  private Integer branchNumber;
  private Integer number;
  private BigDecimal balance;
  private String createdAt;
  private String updatedAt;
  private Integer userId;
}
