package com.letscode.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ValidateUserCredentialsResponse {
  Boolean isValid;
}
