package com.letscode.user.service;

import com.letscode.user.dto.CreateUserRequest;
import com.letscode.user.dto.ValidateUserCredentialsRequest;
import com.letscode.user.model.User;

public interface UserService {
  User createUser(CreateUserRequest request);

  Boolean existsByCpf(String cpf);

  User findByCpf(String cpf);

  Boolean isValid(Integer id, ValidateUserCredentialsRequest request);
}
