package com.week08.zachary.model.order;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "order_n")
@Entity
@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderN implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "order_no")
  private String orderNo;

  @Column(name = "status")
  private String status;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "product_id")
  private Long productId;

  @Column(name = "worksite")
  private String worksite;

  @Column(name = "remark")
  private String remark;

  @Column(name = "create_time", updatable = false)
  @CreationTimestamp
  private Date createTime;

  @Column(name = "update_time")
  @UpdateTimestamp
  private Date updateTime;

  private Date submitTime;
}
