package com.letscode.customer.controller;

import com.letscode.customer.dto.*;
import com.letscode.customer.model.Customer;
import com.letscode.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/users")
public class CustomerController {

  final CustomerService service;

  @Autowired
  public CustomerController(CustomerService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<CreateCustomerResponse> create(
      @RequestBody CreateCustomerRequest request,
      UriComponentsBuilder uriComponentsBuilder) {
    log.info("Entered CUSTOMER create");
    Customer customer = service.create(request);
    URI uri = uriComponentsBuilder.path("/api/users/{id}").buildAndExpand(customer.getId()).toUri();
    log.info("Customer microservice. Created customer is {}", customer);
    return ResponseEntity.created(uri).body(CreateCustomerMapper.toCreateCustomerResponse(customer));
  }

  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<SearchResponse> search(@RequestParam("cpf") String cpf) {
    log.info("Entered CUSTOMER search");
    Boolean isCustomer = service.existsByCpf(cpf);
    SearchResponse response = new SearchResponse(isCustomer);
    log.info("Is the person who is creating an account already a customer?: {}", isCustomer);
    if (isCustomer) {
      response.setCustomerId(service.findByCpf(cpf).getId());
    }
    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/verify")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<VerifyCredentialsResponse> verifyCredentials(
      @RequestParam Map<String, String> params
  ) {
    log.info("Entered CUSTOMER verifyCredentials");
    Boolean isValid = service.verifyCredentials(params.get("cpf"), params.get("loginPassword"));
    log.info("Did the customer entered valid credentials?: {}", isValid);
    VerifyCredentialsResponse response = new VerifyCredentialsResponse(isValid);
    return ResponseEntity.ok().body(response);
  }

}
