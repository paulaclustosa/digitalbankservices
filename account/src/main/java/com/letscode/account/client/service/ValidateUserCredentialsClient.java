package com.letscode.account.client.service;

import com.letscode.account.client.dto.ValidateUserCredentialsRequest;
import com.letscode.account.client.dto.ValidateUserCredentialsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class ValidateUserCredentialsClient {

  public ValidateUserCredentialsResponse execute(Integer id, ValidateUserCredentialsRequest request) {
    try {
      String url = "http://localhost:9081/api/users/validator/{id}";
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
