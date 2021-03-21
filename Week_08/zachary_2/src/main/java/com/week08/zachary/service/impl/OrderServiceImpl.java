package com.week08.zachary.service.impl;

import com.week08.zachary.entity.OrderVo;
import com.week08.zachary.model.order.Order;
import com.week08.zachary.repository.order.OrderRepository;
import com.week08.zachary.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

  @Autowired
  private OrderRepository orderRepository;

  @Override
  public List<Order> findOrder(OrderVo orderVo) {
    Order order = Order.builder().build();
    BeanUtils.copyProperties(orderVo, order);
    List<Order> orders = orderRepository.findAll(Example.of(order));
    return orders;
  }

  @Override
  public void addOrder(OrderVo orderVo) {
    Order order = Order.builder().build();
    BeanUtils.copyProperties(orderVo, order);
    orderRepository.save(order);
  }

  @Override
  public void updateOrder(OrderVo orderVo) {
    Order order = Order.builder().build();
    BeanUtils.copyProperties(orderVo, order);
    orderRepository.save(order);
  }

  @Override
  public void delOrder(OrderVo orderVo) {
    Order order = Order.builder().build();
    BeanUtils.copyProperties(orderVo, order);
    orderRepository.delete(order);
  }
}
