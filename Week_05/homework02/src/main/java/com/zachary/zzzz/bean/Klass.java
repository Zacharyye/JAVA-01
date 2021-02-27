package com.zachary.zzzz.bean;

import lombok.*;

import java.util.List;

@Data
public class Klass {

  List<Student> students;

  public void dong() {
    System.out.println(this.getStudents());
  }
}
