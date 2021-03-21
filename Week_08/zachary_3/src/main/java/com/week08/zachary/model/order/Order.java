package com.week08.zachary.model.order;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "`order`")
@Entity
@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order implements Serializable {
  private static final long serialVersionUID = 1L;
  @Column(name = "id")
  private Long id;

  @EmbeddedId
  private OrderId orderId;

  @Column(name = "status")
  private String status;

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
