package com.letscode.account.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateUserResponse {
  @JsonProperty("id")
  private Integer userId;
}
