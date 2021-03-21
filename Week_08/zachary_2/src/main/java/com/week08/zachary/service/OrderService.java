package com.week08.zachary.service;

import com.week08.zachary.entity.OrderVo;
import com.week08.zachary.model.order.Order;

import java.util.List;

public interface OrderService {
  List<Order> findOrder(OrderVo orderVo);

  void addOrder(OrderVo orderVo);

  void updateOrder(OrderVo orderVo);

  void delOrder(OrderVo orderVo);
}
