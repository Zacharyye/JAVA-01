package com.week07.zachary.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Slf4j
@Aspect
@Order(1)
public class DataSourceAspect {

  @Pointcut("@annotation(com.week07.zachary.aspect.Slave) && execution(* com.week07.zachary.service.impl.*.*(..))")
  public void readPointcut() {}

  @Pointcut("@annotation(com.week07.zachary.aspect.Master) && execution(* com.week07.zachary.service.impl.*.*(..))")
  public void writePointcut() {}

  @Before("readPointcut()")
  public void readBefore(JoinPoint joinPoint) {
    DSContextHolder.slave();
    String className = joinPoint.getTarget().getClass().getName();
    String methodName = joinPoint.getSignature().getName();
    log.debug("{}.{} USE DATASOURCE SLAVE", className, methodName);
  }

  @After("readPointcut()")
  public void readAfter(JoinPoint joinPoint) {
    DSContextHolder.master();
    String className = joinPoint.getTarget().getClass().getName();
    String methodName = joinPoint.getSignature().getName();
    log.debug("{}.{} RESET DATASOURCE MASTER", className, methodName);
  }

  @Before("writePointcut()")
  public void writeBefore(JoinPoint joinPoint) {
    DSContextHolder.master();
    String className = joinPoint.getTarget().getClass().getName();
    String methodName = joinPoint.getSignature().getName();
    log.debug("{}.{} USE DATASOURCE MASTER", className, methodName);
  }
}
