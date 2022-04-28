package com.letscode.account.controller;

import com.letscode.account.dto.*;
import com.letscode.account.model.Account;
import com.letscode.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
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
      @RequestBody CreateAccountRequest request,
      UriComponentsBuilder uriComponentsBuilder) throws IllegalAccessException {
    Account account = accountService.handleCreation(request);
    URI uri = uriComponentsBuilder.path("/api/accounts/{id}").buildAndExpand(account.getId()).toUri();
    return ResponseEntity.created(uri).body(CreateAccountMapper.toCreatedAccountResponse(account));
  }
  
}
