package com.letscode.account.controller;

import com.letscode.account.dto.CreateAccountRequest;
import com.letscode.account.dto.CreateAccountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

/*  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<CreateAccountResponse> createAccount(CreateAccountRequest request) {

    return ResponseEntity.created()
  }*/

}
