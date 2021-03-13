package io.spring.app;

import io.spring.app.model.Fee;
import io.spring.app.model.Student;
import io.spring.app.repository.StudentRepository;
import java.time.LocalDate;
import java.util.Set;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @EventListener(classes = ContextRefreshedEvent.class)
  public void fakeData(ContextRefreshedEvent event) {
    System.out.println("---------------FAKE DATA-----------------");
    ApplicationContext context = event.getApplicationContext();
    StudentRepository studentRepository = context.getBean(StudentRepository.class);

    Fee fee = new Fee();
    fee.setCost(15000);
    fee.setPaid(false);
    fee.setTerm(1);

    Student student = new Student();
    student.setDateOfBirth(LocalDate.of(1999, 06, 25));
    student.setFullName("admin");
    student.setStudentCode("102170053");
    student.setFees(Set.of(fee));

    studentRepository.save(student);
  }
}
