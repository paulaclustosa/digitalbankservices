package com.letscode.account.client.service;

import com.letscode.account.client.dto.SearchUserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchUserClient {

  @Value("${client.user.searcher}")
  private String url;

  public SearchUserResponse searchUser(String cpf) {
    try {
      RestTemplate restTemplate = new RestTemplate();
      return restTemplate.getForObject(url, SearchUserResponse.class, cpf);
    } catch (RestClientException clientException) {
      clientException.printStackTrace();
    }
    return null;
  }
}
