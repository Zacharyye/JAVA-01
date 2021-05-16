package com.zachary.redisdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class RedisCountAspect {
  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Pointcut("@annotation(com.zachary.redisdemo.aspect.RedisCount)")
  public void point() {}

  @Before("point() && @annotation(redisCount)")
  public void before(JoinPoint joinPoint, RedisCount redisCount) throws Exception {
    String key = redisCount.key();
    boolean expire = redisCount.isExpire();
    int leaseTime = redisCount.leaseTime();
    long times = redisCount.times();
    TimeUnit timeUnit = redisCount.timeUnit();

    if(expire) {
      //eg: 频率控制场景
      long count = redisTemplate.opsForValue().increment(key, 1);
      if (count == 1) {
        //证明是第一次，设置该key过期时间，超过redis自动把值删除
        redisTemplate.expire(key, leaseTime, timeUnit);
      }
      if (count > times) {
        throw new Exception("超过频率调用，请稍候再试");
      }
    } else {
      //eg:秒杀场景
      long count = redisTemplate.opsForValue().increment(key, 1);
      if (count > times) {
        throw new Exception("秒杀活动结束，谢谢参与！");
      }
    }
  }
}
