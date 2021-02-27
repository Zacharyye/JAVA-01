package com.zachary.zzzz.jms;

import com.zachary.zzzz.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JmsSender {
  public static void main(String[] args) {
    Student student2 = new Student(201, "KK201", null, null);
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springjms-sender.xml");
    SendService sendService = (SendService) context.getBean("sendService");
    sendService.send(student2);
    System.out.println("send successfully, please visit http://localhost:8161/admin to see it");
  }
}
