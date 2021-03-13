package io.spring.app.service;

import io.spring.app.dto.StudentData;
import io.spring.app.model.Student;
import io.spring.app.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceImplTest {
    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @Test
    void findById() {
        Student student = new Student();
        student.setFullName("fullName");
        student.setStudentCode("123456");
        student.setDateOfBirth(LocalDate.now());

        Mockito.when(studentRepository.findById(1L))
                .thenReturn(Optional.of(student));

        StudentData data = studentService.findById(1L);

        assertEquals("fullName", data.getFullName());
        assertEquals("123456", data.getStudentCode());
        assertEquals(LocalDate.now(), data.getDateOfBirth());
    }
}