package com.zachary.zzzz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "code")
  private String code;

  @Column(name = "bg_name")
  private String bgName;

  @Column(name = "credit_line")
  private BigDecimal creditLine;

  @Column(name = "available_loan_quota")
  private BigDecimal availableLoanQuota;

  @Column(name = "loan_amount_last_month")
  private BigDecimal loanAmountForLastMonth;

  @Column(updatable = false)
  @CreationTimestamp
  private Date createTime;

  @UpdateTimestamp
  private Date updateTime;
}
