package com.zachary.dubbo.demo.consumer;

import com.zachary.dubbo.demo.api.Order;
import com.zachary.dubbo.demo.api.OrderService;
import com.zachary.dubbo.demo.api.User;
import com.zachary.dubbo.demo.api.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DubboClientApplication {
  @DubboReference(version = "1.0.0")
  private UserService userService;

  @DubboReference(version = "1.0.0")
  private OrderService orderService;

  public static void main(String[] args) {
    SpringApplication.run(DubboClientApplication.class).close();
  }

  @Bean
  public ApplicationRunner runner() {
    return args -> {
      User user = userService.findById(1);
      System.out.println("find user id=1 from server: " + user.getName());
      Order order = orderService.findOrderById(1992129);
      System.out.println(String.format("find order name =%s, amount=%f", order.getName(), order.getAmount()));
    };
  }
}
