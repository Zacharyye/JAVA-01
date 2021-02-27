package com.zachary.zzzz.jms;

import org.springframework.stereotype.Component;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component(value = "jmsListener")
public class JmsListener implements MessageListener {

  //收到信息时的动作
  @Override
  public void onMessage(Message message) {
    ObjectMessage message1 = (ObjectMessage) message;
    try {
      System.out.println("收到的信息：" + message1.getObject());
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
}
