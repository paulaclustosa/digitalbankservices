package com.letscode.account.service;

import com.letscode.account.client.dto.*;
import com.letscode.account.dto.CreateAccountRequest;
import com.letscode.account.model.Account;
import com.letscode.account.repository.AccountRepository;
import com.letscode.account.client.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

  final SearchUserClient searchUserClient;
  final ValidateUserCredentialsClient validateUserCredentialsClient;
  final CreateUserClient createUserClient;
  final PasswordEncoder passwordEncoder;
  final AccountRepository accountRepository;


  @Autowired
  public AccountServiceImpl(SearchUserClient searchUserClient, ValidateUserCredentialsClient validateUserCredentialsClient,
                            CreateUserClient createUserClient,
                            PasswordEncoder passwordEncoder, AccountRepository accountRepository) {
    this.searchUserClient = searchUserClient;
    this.validateUserCredentialsClient = validateUserCredentialsClient;
    this.createUserClient = createUserClient;
    this.passwordEncoder = passwordEncoder;
    this.accountRepository = accountRepository;
  }

  @Override
  public Account createAccount(CreateAccountRequest request) {
    // Check if the person is already a user from this bank
    SearchUserResponse searchUserResponse = searchUserClient.searchUser(request.getCpf());

    if (searchUserResponse.getIsUser()) {
      // isUser = true
      Integer userId = searchUserResponse.getUserId();
      ValidateUserCredentialsRequest validateUserCredentialsRequest =
          ValidateUserCredentialsRequest.builder()
              .cpf(request.getCpf())
              .loginPassword(passwordEncoder.encode(request.getLoginPassword().toString()))
              .build();

      // Check if the person entered its correct bank login information (cpf and login password)
      ValidateUserCredentialsResponse validateUserCredentialsResponse =
          validateUserCredentialsClient.validateUser(userId, validateUserCredentialsRequest);

      if (validateUserCredentialsResponse.getIsValid()) {
        // validCredentials = true
        // Create a new account
        Account newAccount = generateAccount(request, searchUserResponse.getUserId());
        return accountRepository.save(newAccount);
      } else {
        // validCredentials = false
        return null;
      }
    } else {
      // isUser = false
      // First create a new user
      CreateUserRequest createUserRequest = CreateUserRequest.builder()
          .cpf(request.getCpf())
          .firstName(request.getFirstName())
          .lastName(request.getLastName())
          .loginPassword(request.getLoginPassword())
          .build();
      CreateUserResponse createUserResponse = createUserClient.createUser(createUserRequest);

      // Then create a new account
      Account newAccount = generateAccount(request, createUserResponse.getUserId());
      return accountRepository.save(newAccount);
    }
  }

  private Account generateAccount(CreateAccountRequest request, Integer id) {
    return Account.builder()
        .branchNumber(request.getBranchNumber())
        .number(new Random(99999).nextInt())
        .password(passwordEncoder.encode(request.getLoginPassword().toString()))
        .userId(id)
        .build();
  }

}
