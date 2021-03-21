package com.week08.zachary;

import cn.hutool.core.lang.Snowflake;
import com.week08.zachary.entity.OrderVo;
import com.week08.zachary.model.order.OrderId;
import com.week08.zachary.service.OrderService;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
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
  @Transactional(rollbackOn = Exception.class)
  @ShardingTransactionType(TransactionType.XA)
  public void testOrder () {
    Snowflake snowflake = new Snowflake(0, 0);
    OrderVo orderVo = OrderVo.builder()
            .id(snowflake.nextId())
            .orderId(OrderId.builder()
                    .orderNo("OR2021031706")
                    .productId(1L)
                    .userId(1L)
                    .build())
            .worksite("测试")
            .status("1")
            .remark("测试")
            .build();
    OrderVo qryOrder = OrderVo.builder()
            .orderId(OrderId.builder()
                    .orderNo("OR2021031706")
                    .productId(1L)
                    .userId(1L)
                    .build())
            .build();
    orderService.addOrder(orderVo);
    System.out.println("after add1: " + orderService.findOrder(qryOrder));
    orderVo.setRemark("测试1");
    orderVo.setWorksite("测试1");
    orderService.updateOrder(orderVo);
    System.out.println("after update1: " + orderService.findOrder(qryOrder));
    orderService.delOrder(orderVo);
    System.out.println("after delete1: " + orderService.findOrder(qryOrder));

    OrderVo orderVo2 = OrderVo.builder()
            .id(snowflake.nextId())
            .orderId(OrderId.builder()
                    .orderNo("OR2021031707")
                    .productId(1L)
                    .userId(2L)
                    .build())
            .worksite("测试")
            .status("1")
            .remark("测试")
            .build();
    OrderVo qryOrder2 = OrderVo.builder()
            .orderId(OrderId.builder()
                    .orderNo("OR2021031707")
                    .productId(1L)
                    .userId(2L)
                    .build())
            .build();
    orderService.addOrder(orderVo2);
    System.out.println("after add2: " + orderService.findOrder(qryOrder2));
    orderVo2.setRemark("测试2");
    orderVo2.setWorksite("测试2");
    orderService.updateOrder(orderVo2);
    System.out.println("after update2: " + orderService.findOrder(qryOrder2));
    orderService.delOrder(orderVo2);
    System.out.println("after delete2: " + orderService.findOrder(qryOrder2));
  }
}
