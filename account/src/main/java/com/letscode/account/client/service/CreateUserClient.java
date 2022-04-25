package com.letscode.account.client.service;

import com.letscode.account.client.dto.CreateUserRequest;
import com.letscode.account.client.dto.CreateUserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CreateUserClient {

  @Value("${client.user.creator}")
  private String url;

  public CreateUserResponse createUser(CreateUserRequest request) {
    try {
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders header = new HttpHeaders();
      header.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
      HttpEntity<CreateUserRequest> entity = new HttpEntity<>(request, header);
      ResponseEntity<CreateUserResponse> response = restTemplate.exchange(
          url,
          HttpMethod.GET,
          entity,
          CreateUserResponse.class
      );
      return response.getBody();
    } catch (RestClientException clientException) {
      clientException.printStackTrace();
    }
    return null;
  }
}
