package com.week07.zachary.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "p_order")
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String orderNo;

  private String status;

  private Long userId;

  private Long productId;

  private String worksite;

  private String remark;

  @Column(updatable = false)
  @CreationTimestamp
  private Date createTime;
  @UpdateTimestamp
  private Date updateTime;
}
