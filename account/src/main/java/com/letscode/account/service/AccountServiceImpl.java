package com.letscode.account.service;

import com.letscode.account.dto.CreateAccountRequest;
import com.letscode.account.dto.SearchUserServerResponse;
import com.letscode.account.model.Account;
import com.letscode.account.repository.AccountRepository;
import com.letscode.account.service.client.SearchUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

  final SearchUserClient searchUserClient;
  final PasswordEncoder passwordEncoder;
  final AccountRepository accountRepository;


  @Autowired
  public AccountServiceImpl(SearchUserClient searchUserClient, PasswordEncoder passwordEncoder,
                            AccountRepository accountRepository) {
    this.searchUserClient = searchUserClient;
    this.passwordEncoder = passwordEncoder;
    this.accountRepository = accountRepository;
  }

  @Override
  public Account createAccount(CreateAccountRequest request) {
    SearchUserServerResponse serverResponse = searchUserClient.searchUser(request.getCpf());
    if (serverResponse.getIsUser()) {
      Account account = new Account();
      account.setUserId(serverResponse.getUserId());
      account.setBranchNumber(request.getBranchNumber());
      account.setNumber(generateNumber());
      account.setPassword(passwordEncoder.encode(request.getPassword().toString()));
      return account;
    }
    return new Account();
  }

  public Integer generateNumber() {
    return new Random(99999).nextInt();
  }
}
