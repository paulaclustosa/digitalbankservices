package com.letscode.account.client.service;

import com.letscode.account.client.dto.VerifyCustomerCredentialsResponse;
import com.letscode.account.dto.CreateAccountRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
public class VerifyCustomerCredentialsClient {

  public VerifyCustomerCredentialsResponse execute(CreateAccountRequest request) {
    try {
      String url = "http://localhost:9081/api/users/verify?cpf=" + request.getCpf() + "&loginPassword=" + request.getLoginPassword();
      //String url = UriComponentsBuilder.fromUriString("http://localhost:9081/api/users/verify").queryParam("cpf").queryParam("loginPassword").build().toUriString();
      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<VerifyCustomerCredentialsResponse> response = restTemplate.getForEntity(url, VerifyCustomerCredentialsResponse.class, request.getCpf(), request.getLoginPassword());
      log.info("Microservice account. Customer verification returned: {}", response);
      return response.getBody();
    } catch (RestClientException clientException) {
      clientException.printStackTrace();
    }
    return null;

  }

}
