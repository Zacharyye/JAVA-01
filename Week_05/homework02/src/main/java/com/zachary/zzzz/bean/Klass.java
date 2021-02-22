package com.zachary.zzzz.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Klass {
  private String grade;

  private String name;

  @Autowired
  private Student student;
}
