package com.letscode.user.controller;

import com.letscode.user.dto.*;
import com.letscode.user.model.User;
import com.letscode.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/users")
public class UserController {

  final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<CreateUserResponse> createUser(
      @RequestBody CreateUserRequest request,
      UriComponentsBuilder uriComponentsBuilder) {
    User user = userService.createUser(request);
    URI uri = uriComponentsBuilder.path("/api/users/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).body(CreateUserMapper.toCreateUserResponse(user));

  }

  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<SearchUserResponse> searchUser(@RequestParam("cpf") String cpf) {
    Boolean isUser = userService.existsByCpf(cpf);
    SearchUserResponse response = SearchUserResponse.builder().isUser(isUser).build();
    if (response.getIsUser()) {
      User user = userService.findByCpf(cpf);
      response.setUserId(user.getId());
    } else {
      response.setUserId(null);
    }
    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/validator/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ValidateUserCredentialsResponse> validateUser(
      @PathVariable("id") Integer id,
      @RequestBody ValidateUserCredentialsRequest request
  ) {
    Boolean isValid = userService.isValid(id, request);
    ValidateUserCredentialsResponse response = ValidateUserCredentialsResponse.builder()
        .isValid(isValid)
        .build();
    return ResponseEntity.ok().body(response);
  }

}
