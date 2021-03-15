package com.week07.zachary.config;

import com.week07.zachary.constant.DSNames;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class DSContextHolder {
  private static final ThreadLocal<DSNames> contextHolder = new ThreadLocal<>();

  private static final AtomicInteger counter = new AtomicInteger(-1);

  public static void set(DSNames dsType) {
    contextHolder.set(dsType);
  }

  public static DSNames get() {
    return contextHolder.get();
  }

  public static void master() {
    set(DSNames.MASTER);
  }

  public static void slave() {
    set(DSNames.SLAVE);
  }
}
