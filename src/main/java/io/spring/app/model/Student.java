package io.spring.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Student extends BaseEntity {
    @Column(unique = true, updatable = false)
    private String studentCode;

    private String fullName;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "owner")
    private Set<Fee> fees = new HashSet<>();
}
