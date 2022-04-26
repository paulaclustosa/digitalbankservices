package com.letscode.account.client.service;

import com.letscode.account.client.dto.SearchUserResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchUserClient {

  public SearchUserResponse searchUser(String cpf) {
    try {
      String url = "http://localhost:9081/api/users/search?cpf=" + cpf;
      RestTemplate restTemplate = new RestTemplate();
      return restTemplate.getForObject(url, SearchUserResponse.class, cpf);
    } catch (RestClientException clientException) {
      clientException.printStackTrace();
    }
    return null;
  }
  
}
