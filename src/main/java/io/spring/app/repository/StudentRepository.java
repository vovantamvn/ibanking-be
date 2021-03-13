package io.spring.app.repository;

import io.spring.app.model.Student;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
  Optional<Student> findByStudentCode(String studentCode);
}
