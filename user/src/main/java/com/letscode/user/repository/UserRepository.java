package com.letscode.user.repository;

import com.letscode.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Boolean existsByCpf(String cpf);

  User findByCpf(String cpf);
}
