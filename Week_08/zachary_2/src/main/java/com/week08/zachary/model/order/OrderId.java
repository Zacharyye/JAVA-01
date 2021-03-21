package com.week08.zachary.model.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderId implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "order_no")
  private String orderNo;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "product_id")
  private Long productId;

}
