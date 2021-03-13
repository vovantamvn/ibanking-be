package io.spring.app.service;

import io.spring.app.dto.StudentData;
import io.spring.app.exception.NotFoundException;
import io.spring.app.model.Student;
import io.spring.app.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public StudentData findById(long id) {
        Student student = convertToStudent(studentRepository.findById(id));
        return convertToDto(student);
    }

    @Override
    public StudentData findByStudentCode(String studentCode) {
        Student student = convertToStudent(studentRepository.findByStudentCode(studentCode));
        return convertToDto(student);
    }

    private StudentData convertToDto(Student student) {
        return modelMapper.map(student, StudentData.class);
    }

    private Student convertToStudent(Optional<Student> optStudent) {
        return optStudent.orElseThrow(NotFoundException::new);
    }
}
