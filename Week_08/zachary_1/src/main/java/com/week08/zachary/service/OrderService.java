package com.week08.zachary.service;

import com.week08.zachary.entity.OrderVo;

public interface OrderService {
  OrderVo findOrder(OrderVo orderVo);

  void addOrder(OrderVo orderVo);

  void updateOrder(OrderVo orderVo);

  void delOrder(OrderVo orderVo);
}
