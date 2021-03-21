package com.week08.zachary.entity;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class OrderVo implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String orderNo;

  private String status;

  private Long userId;

  private Long productId;

  private String worksite;

  private String remark;

  private Date createTime;

  private Date updateTime;

  private Date submitTime;
}
