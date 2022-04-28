package com.letscode.customer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResponse {
  private Boolean isCustomer;
  private Integer customerId;

  public SearchResponse(Boolean isCustomer) {
    this.isCustomer = isCustomer;
  }
}
