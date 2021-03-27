package io.spring.app.core.account;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountData {
  @Email private String email;

  @NotBlank private String username;

  @NotBlank private String fullName;

  @Pattern(regexp = "[0-9]{10}")
  private String phone;

  private long balance;
}
