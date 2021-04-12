package zachary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zachary.producer.KafkaProducer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaProducerApplication.class)
public class KafkaProducerApplicationTest {
  @Autowired
  private KafkaProducer kafkaProducer;

  @Test
  public void kafkaProducer () {
    this.kafkaProducer.send();
  }

  @Test
  public void contextLoads () {

  }
}
