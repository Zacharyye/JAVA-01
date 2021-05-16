package com.zachary.redisdemo.controller;

import com.zachary.redisdemo.aspect.RedisCount;
import com.zachary.redisdemo.lock.RedisDistributedLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@Slf4j
@RestController
public class TestController {
  @Resource
  private RedisTemplate<Object, Object> redisTemplate;

  @PostMapping("/order")
  @RedisCount(key = "test.createOrder", times = 600, isExpire = true, leaseTime = 60000)
  public String createorder() throws InterruptedException {
    log.info("开始创建订单");
    Boolean isLock = RedisDistributedLock.isLock("testLock","456789", redisTemplate);

    if (!isLock) {
      log.info("锁已经被占用");
      return "fail";
    } else {
      //...处理逻辑
    }
    Thread.sleep(10000);
    RedisDistributedLock.releaseLock("testLock", "456789", redisTemplate);
    return "success";
  }
}
