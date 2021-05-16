package com.zachary.springbootkafka;

import org.junit.Test;

import java.math.BigDecimal;

public class SomeTest {
  @Test
  public void test() {
    System.out.println(new BigDecimal(4000000.0).divide(new BigDecimal("2"), 2, BigDecimal.ROUND_HALF_UP));
    System.out.println(new BigDecimal("2000000.00").compareTo(new BigDecimal("4000000.0").divide(new BigDecimal("2"), 2, BigDecimal.ROUND_HALF_UP)));
  }
}
