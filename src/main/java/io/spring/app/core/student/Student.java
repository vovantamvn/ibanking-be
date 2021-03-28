package io.spring.app.core.student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import io.spring.app.core.BaseEntity;
import io.spring.app.core.bill.Bill;
import io.spring.app.core.fee.Fee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student extends BaseEntity {
    @Column(unique = true, updatable = false)
    private String studentCode;

    @NotBlank
    private String fullName;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Fee> fees = new ArrayList<>();
}
