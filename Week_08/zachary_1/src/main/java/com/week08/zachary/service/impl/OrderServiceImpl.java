package com.week08.zachary.service.impl;

import com.week08.zachary.entity.OrderVo;
import com.week08.zachary.repository.RepositoryFactory;
import com.week08.zachary.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

  @Autowired
  private RepositoryFactory repositoryFactory;

  @Override
  public OrderVo findOrder(OrderVo orderVo) {
    Object obj = repositoryFactory.getOrderRepository(orderVo).findOne(Example.of(
            repositoryFactory.getOrderModel(orderVo)
    )).orElse(null);
    OrderVo resultOrder = OrderVo.builder().build();
    if(!Objects.isNull(obj)) {
      BeanUtils.copyProperties(obj, resultOrder);
    }
    return resultOrder;
  }

  @Override
  public void addOrder(OrderVo orderVo) {
    repositoryFactory.getOrderRepository(orderVo).save(
            repositoryFactory.getOrderModel(orderVo));
  }

  @Override
  public void updateOrder(OrderVo orderVo) {
    repositoryFactory.getOrderRepository(orderVo).save(
            repositoryFactory.getOrderModel(orderVo));
  }

  @Override
  public void delOrder(OrderVo orderVo) {
    repositoryFactory.getOrderRepository(orderVo).delete(
            repositoryFactory.getOrderModel(orderVo));
  }
}
