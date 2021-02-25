package io.spring.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@Entity
public class Fee extends BaseEntity {
    @ManyToOne
    private Account owner;

    @PositiveOrZero
    private long cost;
}
