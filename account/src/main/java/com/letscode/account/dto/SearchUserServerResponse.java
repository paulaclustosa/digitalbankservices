package com.letscode.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SearchUserServerResponse {
  private Boolean isUser;
  @JsonProperty("user_id")
  private Integer userId;
}
