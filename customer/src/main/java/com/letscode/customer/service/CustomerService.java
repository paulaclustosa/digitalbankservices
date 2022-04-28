package com.letscode.customer.service;

import com.letscode.customer.dto.CreateCustomerRequest;
import com.letscode.customer.model.Customer;

public interface CustomerService {
  Customer create(CreateCustomerRequest request);

  Boolean existsByCpf(String cpf);

  Customer findByCpf(String cpf);

  Boolean verifyCredentials(String cpf, String password);
}
