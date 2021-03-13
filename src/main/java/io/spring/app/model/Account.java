package io.spring.app.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Account extends BaseEntity {
  @Email
  @Column(unique = true)
  private String email;

  @NotBlank
  @Column(unique = true)
  private String username;

  private String password;

  @NotBlank private String fullName;

  @Pattern(regexp = "[0-9]{10}")
  private String phone;

  @PositiveOrZero private long balance;
}
