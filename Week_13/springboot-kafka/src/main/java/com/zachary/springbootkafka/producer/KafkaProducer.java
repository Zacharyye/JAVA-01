package com.zachary.springbootkafka.producer;

import com.zachary.springbootkafka.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducer {
  @Autowired
  private KafkaTemplate template;

  @Autowired
  private KafkaConsumer kafkaConsumer;

  @RequestMapping("/sendMsg")
  public String sendMsg (String topic, String message) {
    template.send(topic, message);
    return "success";
  }
}
