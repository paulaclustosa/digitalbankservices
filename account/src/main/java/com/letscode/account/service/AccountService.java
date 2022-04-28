package com.letscode.account.service;

import com.letscode.account.dto.CreateAccountRequest;
import com.letscode.account.model.Account;

public interface AccountService {
  Account handleCreation(CreateAccountRequest request) throws IllegalAccessException;

  Account create(CreateAccountRequest request, Integer customerId);
}
