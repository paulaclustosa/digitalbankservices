package com.letscode.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchUserResponse {
  private Boolean isUser;
  @JsonProperty("user_id")
  private Integer userId;

  @Builder
  public SearchUserResponse(Boolean isUser) {
    this.isUser = isUser;
  }
}
