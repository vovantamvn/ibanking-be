package io.spring.app.core.student;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentData {
    private String studentCode;

    private String fullName;

    private LocalDate dateOfBirth;
}
