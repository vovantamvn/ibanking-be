package io.spring.app.core.fee;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.spring.app.core.BaseEntity;
import io.spring.app.core.bill.Bill;
import io.spring.app.core.student.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Fee extends BaseEntity {
    @NotNull
    @ManyToOne
    private Student student;

    @PositiveOrZero
    private long cost;

    private int term;

    @OneToMany(mappedBy = "fee", cascade = CascadeType.ALL)
    private List<Bill> bills = new ArrayList<>();
}
