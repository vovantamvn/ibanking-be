package io.spring.app.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Otp extends BaseEntity {
  @NotBlank private String content;

  @Column(nullable = false, updatable = false)
  private LocalDateTime expireAt;
}
