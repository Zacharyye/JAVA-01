package com.zachary.redisdemo.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

import java.nio.charset.StandardCharsets;

@Slf4j
public class RedisDistributedLock {

  /**
   * 超时时间
   */
  private static final long TIMEOUT_MILLIS = 15000;

  /**
   * 重试次数
   */
  private static final int RETRY_TIMES = 10;

  /**
   * 睡眠时间
   */
  private static final long SLEEP_MILLIS = 500;

  /**
   * 用来加锁的lua脚本
   * 因为新版的redis加锁操作已经为原子性操作
   * 所以放弃使用lua脚本
   */
  private static final String LOCK_LUA =
          "if redis.call(\"setnx\",KEYS[1],ARGV[1]) == 1" +
            "then " +
            " return redis.call('expire',KEYS[1],ARGV[2])" +
            "else " +
            " return 0 " +
            "end";

  /**
   * 用来释放分布式锁的lua脚本
   * 如果redis.get(KEYS[1]) == ARGV[1],则redis delete KEYS[1]
   * 否则返回0
   * KEYS[1],ARGV[1] 是参数，我们只调用的时候，传递这两个参数就可以了
   * KEYS[1] 主要用来传递在Redis中用作key值的参数
   * ARGV[1] 主要用来传递在redis中用作value值的参数
   */
  private static final String UNLOCK_LUA =
          "if redis.call(\"get\",KEYS[1]) == ARGV[1] " +
                  "then " +
                  " return redis.call(\"del\",KEYS[1]) " +
                  "else " +
                  " return 0 " +
                  "end ";

  /**
   *  检查redisKey是否上锁
   * @param redisKey
   * @param value
   * @param template
   * @return
   */
  public static Boolean isLock(String redisKey, String value, RedisTemplate<Object, Object> template) {
    return lock(redisKey, value, template, RETRY_TIMES);
  }

  private static Boolean lock(String redisKey,
                              String value,
                              RedisTemplate<Object, Object> template,
                              int retryTimes) {
    boolean result = lockKey(redisKey, value, template);
    while(!(result) && retryTimes-- > 0) {
      try {
        log.debug("lock failed, retrying...{}", retryTimes);
        Thread.sleep(RedisDistributedLock.SLEEP_MILLIS);
      } catch (InterruptedException e) {
        return false;
      }
      result = lockKey(redisKey, value, template);
    }
    return result;
  }

  private static Boolean lockKey(final String key,
                                 final String value,
                                 RedisTemplate<Object, Object> template) {
    try {
      RedisCallback<Boolean> callback = (connection) -> connection.set(
              key.getBytes(StandardCharsets.UTF_8),
              value.getBytes(StandardCharsets.UTF_8),
              Expiration.milliseconds(RedisDistributedLock.TIMEOUT_MILLIS),
              RedisStringCommands.SetOption.SET_IF_ABSENT
      );
      return template.execute(callback);
    } catch (Exception e) {
      log.info("lock key fail because of ", e);
    }
    return false;
  }

  /**
   * 释放分布式锁资源
   * @param redisKey
   * @param value
   * @param template
   * @return
   */
  public static Boolean releaseLock(String redisKey,
                                    String value,
                                    RedisTemplate<Object, Object> template) {
    try {
      RedisCallback<Boolean> callback = (connection) -> connection.eval(
              UNLOCK_LUA.getBytes(),
              ReturnType.BOOLEAN,
              1,
              redisKey.getBytes(StandardCharsets.UTF_8),
              value.getBytes(StandardCharsets.UTF_8)
      );
      return template.execute(callback);
    } catch (Exception e) {
      log.info("release lock fail because of ", e);
    }
    return false;
  }

}
