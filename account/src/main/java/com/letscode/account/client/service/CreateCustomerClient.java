package com.letscode.account.client.service;

import com.letscode.account.client.dto.CreateCustomerRequest;
import com.letscode.account.client.dto.CreateCustomerResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CreateCustomerClient {

  public CreateCustomerResponse execute(CreateCustomerRequest request) {
    try {
      String url = "http://localhost:9081/api/users";
      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<CreateCustomerResponse> response = restTemplate.postForEntity(url, request, CreateCustomerResponse.class);
      return response.getBody();
    } catch (RestClientException clientException) {
      clientException.printStackTrace();
    }
    return null;
  }

}
