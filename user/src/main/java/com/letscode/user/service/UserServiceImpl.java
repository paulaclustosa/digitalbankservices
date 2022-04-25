package com.letscode.user.service;

import com.letscode.user.model.User;
import com.letscode.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
  public Boolean existsByCpf(String cpf) {
    return userRepository.existsByCpf(cpf);
  }

  @Override
  public User findByCpf(String cpf) {
    return userRepository.findByCpf(cpf);
  }


  /*@Override
  public Optional<User> findByCpf(CreateUserRequest request) throws ChangeSetPersister.NotFoundException {

    User user = CreateUserMapper.toUser(request);
    user.setPassword(passwordEncoder.encode(request.getPassword().toString()));

  }*/

}
