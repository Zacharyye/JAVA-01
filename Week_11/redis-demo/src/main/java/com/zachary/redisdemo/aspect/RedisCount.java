package com.zachary.redisdemo.aspect;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RedisCount {
  /**
   * redis计数key
   * @return
   */
  String key();

  /**
   * redis计数控制次数
   * @return
   */
  long times();

  /**
   * 是否频控
   * @return
   */
  boolean isExpire();

  int leaseTime() default 60000;

  TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
