package com.zachary.zzzz.configuration;

import com.zachary.zzzz.bean.Klass;
import com.zachary.zzzz.bean.School;
import com.zachary.zzzz.bean.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebConfiguration.class)
public class WebAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean(Student.class)
  public Student student() {
//    return new Student("haha","18");
    return null;
  }

  @Bean
  @ConditionalOnMissingBean(Klass.class)
  public Klass klass() {
    return new Klass();
  }

  @Bean
  @ConditionalOnMissingBean(School.class)
  public School school() {
    return new School();
  }
}
