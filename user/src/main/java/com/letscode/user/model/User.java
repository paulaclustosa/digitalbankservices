package com.letscode.user.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class User {
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
  public User(String cpf, String firstName, String lastName) {
    this.cpf = cpf;
    this.firstName = firstName;
    this.lastName = lastName;
  }

}
