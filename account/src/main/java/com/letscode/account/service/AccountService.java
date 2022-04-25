package com.letscode.account.service;

import com.letscode.account.dto.CreateAccountRequest;
import com.letscode.account.model.Account;

public interface AccountService {
  Account createAccount(CreateAccountRequest request);
}
