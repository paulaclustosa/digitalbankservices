package com.letscode.account.controller;

import com.letscode.account.dto.CreateAccountMapper;
import com.letscode.account.dto.CreateAccountRequest;
import com.letscode.account.dto.CreateAccountResponse;
import com.letscode.account.model.Account;
import com.letscode.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

  final AccountService accountService;

  @Autowired
  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Object> createAccount(
      CreateAccountRequest request,
      UriComponentsBuilder uriComponentsBuilder) {
    Account account = accountService.createAccount(request);
    if (account == null) return ResponseEntity.ok().body("Invalid user credentials (cpf and/or login password).");
    else {
      URI uri = uriComponentsBuilder.path("/api/accounts/{id}").buildAndExpand(account.getId()).toUri();
      return ResponseEntity.created(uri).body(CreateAccountMapper.toCreatedAccountResponse(account));
    }
  }
}
