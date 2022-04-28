package com.letscode.account.client.service;

import com.letscode.account.client.dto.SearchCustomerResponse;
import com.letscode.account.dto.CreateAccountRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class SearchCustomerClient {

  public SearchCustomerResponse execute(CreateAccountRequest request) {
    try {
      String url = "http://localhost:9081/api/users/search?cpf={cpf}";
      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<SearchCustomerResponse> response = restTemplate.getForEntity(url, SearchCustomerResponse.class, request.getCpf());
      log.info("Microservice account. Search for customer returned: {}", response);
      return response.getBody();
    } catch (RestClientException clientException) {
      clientException.printStackTrace();
    }
    return null;
  }

}
