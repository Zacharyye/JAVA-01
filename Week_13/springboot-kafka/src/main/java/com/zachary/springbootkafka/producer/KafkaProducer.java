package com.zachary.springbootkafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducer {
  @Autowired
  private KafkaTemplate template;

  @RequestMapping("/sendMsg")
  public String sendMsg (String topic, String message) {
    template.send(topic, message);
    return "success";
  }
}
