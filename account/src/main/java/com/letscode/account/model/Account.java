package com.letscode.account.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "branch_number")
  private Integer branchNumber;

  @Column(name = "number")
  private Integer number;

  @Column(name = "account_password")
  private String password;

  @Column(name = "balance")
  private BigDecimal balance;

  @Column(name = "created_at")
  @CreatedDate
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @LastModifiedDate
  private LocalDateTime updatedAt;

  @Column(name = "customer_id")
  private Integer customerId;

  @Builder
  public Account(Integer branchNumber, Integer number, String password, Integer customerId) {
    this.branchNumber = branchNumber;
    this.number = number;
    this.password = password;
    this.balance = new BigDecimal(0);
    this.customerId = customerId;
  }
}
