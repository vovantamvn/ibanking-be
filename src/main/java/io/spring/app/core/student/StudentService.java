package io.spring.app.core.student;

public interface StudentService {
  StudentData findById(long id);

  StudentData findByStudentCode(String studentCode);
}
