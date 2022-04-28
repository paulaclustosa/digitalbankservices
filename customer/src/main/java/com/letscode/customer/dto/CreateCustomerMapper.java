package com.letscode.customer.dto;

import com.letscode.customer.model.Customer;

public class CreateCustomerMapper {

  private CreateCustomerMapper() {
  }

  public static Customer toUser(CreateCustomerRequest request) {
    return Customer.builder()
        .cpf(request.getCpf())
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .build();
  }

  public static CreateCustomerResponse toCreateCustomerResponse(Customer customer) {
    return CreateCustomerResponse.builder()
        .id(customer.getId())
        .cpf(customer.getCpf())
        .firstName(customer.getFirstName())
        .lastName(customer.getLastName())
        .build();
  }

}
