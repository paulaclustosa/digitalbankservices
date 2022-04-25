package com.letscode.user.service;

import com.letscode.user.dto.CreateUserMapper;
import com.letscode.user.dto.CreateUserRequest;
import com.letscode.user.dto.ValidateUserCredentialsRequest;
import com.letscode.user.model.User;
import com.letscode.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

  final UserRepository userRepository;
  final PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User createUser(CreateUserRequest request) {
    User user = CreateUserMapper.toUser(request);
    user.setLoginPassword(passwordEncoder.encode(request.getLoginPassword().toString()));
    return userRepository.save(user);
  }

  @Override
  public Boolean existsByCpf(String cpf) {
    return userRepository.existsByCpf(cpf);
  }

  @Override
  public User findByCpf(String cpf) {
    return userRepository.findByCpf(cpf);
  }

  public Boolean isValid(Integer id, ValidateUserCredentialsRequest request) {
    User user = userRepository.getById(id);
    return ((Objects.equals(user.getCpf(), request.getCpf())) && Objects.equals(user.getLoginPassword(), request.getLoginPassword()));
  }

}
