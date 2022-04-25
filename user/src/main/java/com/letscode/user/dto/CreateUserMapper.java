package com.letscode.user.dto;

import com.letscode.user.model.User;

public class CreateUserMapper {

  private CreateUserMapper() {
  }

  public static User toUser(CreateUserRequest request) {
    return User.builder()
        .cpf(request.getCpf())
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .build();
  }

  public static CreateUserResponse toCreateUserResponse(User user) {
    return CreateUserResponse.builder()
        .id(user.getId())
        .cpf(user.getCpf())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .build();
  }

}
