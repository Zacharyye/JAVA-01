package zachary.bean;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class School {
  private String name;

  @Autowired
  private Klass klass;

  public School(Klass klass) {
    this.klass = klass;
  }

  public void showKlass() {
    System.out.println(klass);
  }
}
