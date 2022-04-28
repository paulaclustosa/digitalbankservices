package com.letscode.customer.repository;

import com.letscode.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  Boolean existsByCpf(String cpf);

  Customer findByCpf(String cpf);
}
