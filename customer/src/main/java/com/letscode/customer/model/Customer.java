package com.letscode.customer.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "cpf")
  private String cpf;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "login_password")
  private String loginPassword;

  @Column(name = "created_at")
  @CreatedDate
  private LocalDateTime createdAt;

  @Builder
  public Customer(String cpf, String firstName, String lastName) {
    this.cpf = cpf;
    this.firstName = firstName;
    this.lastName = lastName;
  }

}
