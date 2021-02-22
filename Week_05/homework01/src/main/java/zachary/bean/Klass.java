package zachary.bean;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Klass {
  private String grade;

  private String name;

  @Autowired
  private Student student;

  public Klass(Student student) {
    this.student = student;
  }

  public void showStudent() {
    System.out.println(student);
  }
}
