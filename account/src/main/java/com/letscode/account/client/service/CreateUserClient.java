package com.letscode.account.client.service;

import com.letscode.account.client.dto.CreateUserRequest;
import com.letscode.account.client.dto.CreateUserResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CreateUserClient {

  public CreateUserResponse execute(CreateUserRequest request) {
    try {
      String url = "http://localhost:9081/api/users";
      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<CreateUserResponse> response = restTemplate.postForEntity(url, request, CreateUserResponse.class);
      return response.getBody();
    } catch (RestClientException clientException) {
      clientException.printStackTrace();
    }
    return null;
  }

}
