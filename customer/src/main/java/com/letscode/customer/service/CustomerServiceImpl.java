package com.letscode.customer.service;

import com.letscode.customer.dto.CreateCustomerMapper;
import com.letscode.customer.dto.CreateCustomerRequest;
import com.letscode.customer.model.Customer;
import com.letscode.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  CustomerRepository repository;
  PasswordEncoder encoder;

  @Autowired
  public CustomerServiceImpl(CustomerRepository repository, PasswordEncoder encoder) {
    this.repository = repository;
    this.encoder = encoder;
  }

  @Override
  public Customer create(CreateCustomerRequest request) {
    Customer customer = CreateCustomerMapper.toUser(request);
    customer.setLoginPassword(encoder.encode(Integer.toString(request.getLoginPassword())));
    return repository.save(customer);
  }

  @Override
  public Boolean existsByCpf(String cpf) {
    return repository.existsByCpf(cpf);
  }

  @Override
  public Customer findByCpf(String cpf) {
    return repository.findByCpf(cpf);
  }

  public Boolean verifyCredentials(String cpf, String loginPassword) {
    Customer customer = findByCpf(cpf);
    log.info("Customer CPF from db is: {}", customer.getCpf());
    log.info("Customer loginPassword from db is: {}", customer.getLoginPassword());


    String encoded = encoder.encode(Integer.toString(Integer.parseInt(loginPassword)));
    log.info("Customer cpf from ACCOUNT is: {}", cpf);
    // TODO correct this part (with encode is not working)
    log.info("Customer loginPassword from ACCOUNT is: {}", encoded);

    return ((Objects.equals(customer.getCpf(), cpf)) && Objects.equals(customer.getLoginPassword(), encoded));
  }

}
