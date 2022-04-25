package com.letscode.user.controller;

import com.letscode.user.dto.CreateUserRequest;
import com.letscode.user.dto.CreateUserResponse;
import com.letscode.user.dto.SearchUserResponse;
import com.letscode.user.model.User;
import com.letscode.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

  final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

/*  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CreateUserResponse createUser(@RequestBody @Valid CreateUserRequest request) {

  }*/

  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<SearchUserResponse> searchUser(@RequestParam(name = "cpf") String cpf) {
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

}
