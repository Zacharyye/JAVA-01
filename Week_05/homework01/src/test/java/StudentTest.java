import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zachary.bean.School;
import zachary.bean.Student;
import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class StudentTest {

  //2.自动装配
  @Resource
  Student student1;

  @Resource
  School school;

  @Test
  public void test1() {
    //1.手动装配
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    Student student = (Student) ctx.getBean("user");
    student.sayHello();
  }

  @Test
  public void test2() {
    student1.sayHello();
  }

  @Test
  public void test3() {
    school.showKlass();
  }

}
