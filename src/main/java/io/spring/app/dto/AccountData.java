package io.spring.app.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class AccountData {
    @Email
    private String email;

    @NotBlank
    private String username;

    @NotBlank
    private String fullName;

    @Pattern(regexp = "[0-9]{10}")
    private String phone;

    private long balance;
}
