package com.letscode.account.service;

import com.letscode.account.client.dto.*;
import com.letscode.account.dto.CreateAccountRequest;
import com.letscode.account.model.Account;
import com.letscode.account.repository.AccountRepository;
import com.letscode.account.client.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

  final SearchCustomerClient searchCustomerClient;
  final VerifyCustomerCredentialsClient verifyCustomerCredentialsClient;
  final CreateCustomerClient createCustomerClient;
  final PasswordEncoder encoder;
  final AccountRepository repository;


  @Autowired
  public AccountServiceImpl(SearchCustomerClient searchCustomerClient, VerifyCustomerCredentialsClient verifyCustomerCredentialsClient,
                            CreateCustomerClient createCustomerClient,
                            PasswordEncoder encoder, AccountRepository repository) {
    this.searchCustomerClient = searchCustomerClient;
    this.verifyCustomerCredentialsClient = verifyCustomerCredentialsClient;
    this.createCustomerClient = createCustomerClient;
    this.encoder = encoder;
    this.repository = repository;
  }

  @Override
  public Account handleCreation(CreateAccountRequest request) throws IllegalAccessException {
    SearchCustomerResponse searchCustomerResponse = searchCustomerClient.execute(request);

    if (searchCustomerResponse.getIsCustomer()) {
      if (verifyCustomerCredentialsClient.execute(request).getIsValid()) {
        Account account = create(request, searchCustomerResponse.getCustomerId());
        return repository.save(account);
      } else {
        throw new IllegalAccessException();
      }
    } else {
      CreateCustomerRequest createCustomerRequest = CreateCustomerRequest.builder()
          .cpf(request.getCpf())
          .firstName(request.getFirstName())
          .lastName(request.getLastName())
          .loginPassword(request.getLoginPassword())
          .build();
      CreateCustomerResponse createCustomerResponse = createCustomerClient.execute(createCustomerRequest);
      Account account = create(request, createCustomerResponse.getCustomerId());
      return repository.save(account);
    }
  }

  @Override
  public Account create(CreateAccountRequest request, Integer customerId) {
    return Account.builder()
        .branchNumber(request.getBranchNumber())
        .number(new Random(99999).nextInt())
        .password(encoder.encode(request.getLoginPassword().toString()))
        .customerId(customerId)
        .build();
  }


}
