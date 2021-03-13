package io.spring.app.repository;

import io.spring.app.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Optional<Student> findByStudentCode(String studentCode);
}
