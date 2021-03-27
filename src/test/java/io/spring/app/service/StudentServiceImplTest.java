package io.spring.app.service;

import static org.junit.jupiter.api.Assertions.*;

import io.spring.app.core.student.StudentData;
import io.spring.app.core.student.Student;
import io.spring.app.core.student.StudentRepository;
import java.time.LocalDate;
import java.util.Optional;

import io.spring.app.core.student.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class StudentServiceImplTest {
  @MockBean private StudentRepository studentRepository;

  @Autowired private StudentService studentService;

  @Test
  void findById() {
    Student student = new Student();
    student.setFullName("fullName");
    student.setStudentCode("123456");
    student.setDateOfBirth(LocalDate.now());

    Mockito.when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

    StudentData data = studentService.findById(1L);

    assertEquals("fullName", data.getFullName());
    assertEquals("123456", data.getStudentCode());
    assertEquals(LocalDate.now(), data.getDateOfBirth());
  }
}
