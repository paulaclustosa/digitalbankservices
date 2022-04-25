package com.letscode.account.client.service;

import com.letscode.account.client.dto.ValidateUserCredentialsRequest;
import com.letscode.account.client.dto.ValidateUserCredentialsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class ValidateUserCredentialsClient {

  @Value("${client.user.validator}")
  private String url;

  public ValidateUserCredentialsResponse validateUser(Integer id, ValidateUserCredentialsRequest request) {
    try {
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders header = new HttpHeaders();
      header.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
      HttpEntity<ValidateUserCredentialsRequest> entity = new HttpEntity<>(request, header);
      ResponseEntity<ValidateUserCredentialsResponse> response = restTemplate.exchange(
          url,
          HttpMethod.GET,
          entity,
          ValidateUserCredentialsResponse.class,
          id
      );
      return response.getBody();
    } catch (RestClientException clientException) {
      clientException.printStackTrace();
    }
    return null;
  }
}
