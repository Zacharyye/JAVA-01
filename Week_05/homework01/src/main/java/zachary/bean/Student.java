package zachary.bean;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ToString
public class Student {

  private String name;

  private String age;

  public void sayHello() {
    System.out.println("Hello, there!");
  }
}
