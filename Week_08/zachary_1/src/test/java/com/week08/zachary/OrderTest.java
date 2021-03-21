package com.week08.zachary;

import com.week08.zachary.entity.OrderVo;
import com.week08.zachary.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderTest {
  @Autowired
  private OrderService orderService;

  @Test
  @Transactional
  public void testOrder () {
    OrderVo orderVo = OrderVo.builder()
            .orderNo("OR2021031706")
            .userId(1L)
            .productId(1L)
            .worksite("测试")
            .status("1")
            .remark("测试")
            .build();
    OrderVo qryOrder = OrderVo.builder()
            .orderNo("OR2021031706")
            .userId(1L)
            .productId(1L)
            .build();
    orderService.addOrder(orderVo);
    orderVo = orderService.findOrder(qryOrder);
    System.out.println("after add1: " + orderVo);
    orderVo.setRemark("测试1");
    orderVo.setWorksite("测试1");
    orderService.updateOrder(orderVo);
    orderVo = orderService.findOrder(qryOrder);
    System.out.println("after update1: " + orderVo);
    orderService.delOrder(orderVo);
    orderVo = orderService.findOrder(qryOrder);
    System.out.println("after delete1: " + orderVo);

    OrderVo orderVo2 = OrderVo.builder()
            .orderNo("OR2021031707")
            .userId(2L)
            .productId(1L)
            .worksite("测试")
            .status("1")
            .remark("测试")
            .build();
    OrderVo qryOrder2 = OrderVo.builder()
            .orderNo("OR2021031707")
            .userId(2L)
            .productId(1L)
            .build();
    orderService.addOrder(orderVo2);
    orderVo2 = orderService.findOrder(qryOrder2);
    System.out.println("after add2: " + orderVo2);
    orderVo2.setRemark("测试2");
    orderVo2.setWorksite("测试2");
    orderService.updateOrder(orderVo2);
    orderVo2 = orderService.findOrder(qryOrder2);
    System.out.println("after update2: " + orderVo2);
    orderService.delOrder(orderVo2);
    orderVo2 = orderService.findOrder(qryOrder2);
    System.out.println("after delete2: " + orderVo2);
  }
}
