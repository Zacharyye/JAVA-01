package com.zachary.dubbo.demo.provider;

import com.zachary.dubbo.demo.api.Order;
import com.zachary.dubbo.demo.api.OrderService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0", tag = "red", weight = 100)
public class OrderServiceImpl implements OrderService {
  @Override
  public Order findOrderById(int id) {
    return new Order(id, "Cuijing" + System.currentTimeMillis(), 9.9f);
  }
}
