package io.spring.app.controller;

import io.spring.app.dto.StudentData;
import io.spring.app.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentControllerTest {
  @MockBean private StudentService studentService;

  @Autowired private TestRestTemplate restTemplate;

  @Test
  void findById() {
    restTemplate.getForObject("/students/102170053", StudentData.class);
    Mockito.verify(studentService).findByStudentCode("102170053");
  }
}
