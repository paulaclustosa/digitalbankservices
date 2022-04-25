package com.letscode.account.service.client;

import com.letscode.account.dto.SearchUserServerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class SearchUserClient {

  @Value("${client.user.searcher}")
  private String url;

  public SearchUserServerResponse searchUser(String cpf) {
    try {
      RestTemplate restTemplate = new RestTemplate();
      return restTemplate.getForObject(url, SearchUserServerResponse.class, cpf);
    } catch (RestClientException clientException) {
      clientException.printStackTrace();
    }
    return null;
  }
}
