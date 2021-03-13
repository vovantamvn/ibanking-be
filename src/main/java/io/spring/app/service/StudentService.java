package io.spring.app.service;

import io.spring.app.dto.StudentData;

public interface StudentService {
  StudentData findById(long id);

  StudentData findByStudentCode(String studentCode);
}
