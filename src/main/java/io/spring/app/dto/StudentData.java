package io.spring.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentData {
    private String studentCode;

    private String fullName;

    private LocalDate dateOfBirth;
}
