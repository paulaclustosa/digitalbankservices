package com.letscode.account.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SearchUserResponse {
  private Boolean isUser;
  @JsonProperty("user_id")
  private Integer userId;
}
