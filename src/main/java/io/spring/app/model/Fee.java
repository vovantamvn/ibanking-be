package io.spring.app.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Fee extends BaseEntity {
  @ManyToOne private Student owner;

  @PositiveOrZero private long cost;

  private int term;

  private boolean isPaid = false;
}
