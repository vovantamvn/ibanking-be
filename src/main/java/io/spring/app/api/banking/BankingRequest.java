package io.spring.app.api.banking;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Getter
public class BankingRequest {
    @NotBlank(message = "Username must be not blank")
    private String username;
    @Pattern(regexp = "[0-9]{9}")
    private String studentCode;
    @Positive(message = "Amount must be a positive number")
    private int amount;
}