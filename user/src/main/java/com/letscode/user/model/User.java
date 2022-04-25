package com.letscode.user.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
  private String password;

  @Builder
  public User(String cpf, String firstName, String lastName, String password) {
    this.cpf = cpf;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
  }

}
