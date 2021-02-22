package com.zachary.zzzz.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private String name;
  private String age;

  public void sayHello() {
    System.out.println("Hello, there!");
  }
}
