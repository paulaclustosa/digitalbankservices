package com.letscode.user.service;

import com.letscode.user.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
  Boolean existsByCpf(String cpf);

  User findByCpf(String cpf);
}
