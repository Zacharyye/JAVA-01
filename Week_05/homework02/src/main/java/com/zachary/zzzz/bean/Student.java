package com.zachary.zzzz.bean;

import lombok.*;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import java.io.Serializable;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable, BeanNameAware, ApplicationContextAware {

  private int id;
  private String name;

  private String beanName;
  private ApplicationContext applicationContext;

  public void init() {
    System.out.println("Hello, there!");
  }

  public void print() {
    System.out.println(this.beanName);
    System.out.println("    context.getBeanDefinitionNames() ===>> " +
            String.join("," , applicationContext.getBeanDefinitionNames()));
  }
}
