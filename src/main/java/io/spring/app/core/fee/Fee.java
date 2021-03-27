package io.spring.app.core.fee;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.PositiveOrZero;

import io.spring.app.core.BaseEntity;
import io.spring.app.core.student.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Fee extends BaseEntity {
    @ManyToOne
    private Student student;

    @PositiveOrZero
    private long cost;

    private int term;

    private boolean isPaid = false;

    @Override
    public String toString() {
        return "Fee{" +
                "cost=" + cost +
                ", term=" + term +
                ", isPaid=" + isPaid +
                '}';
    }
}
