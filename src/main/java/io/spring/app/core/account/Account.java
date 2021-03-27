package io.spring.app.core.account;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import io.spring.app.core.BaseEntity;
import io.spring.app.core.bill.Bill;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Account extends BaseEntity {
    @Email
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "[a-z0-9]{4,20}")
    @Column(unique = true)
    private String username;

    private String password;

    @NotBlank
    private String fullName;

    @Pattern(regexp = "[0-9]{10}")
    private String phone;

    @PositiveOrZero
    private long balance;

    @OneToMany(mappedBy = "account")
    private List<Bill> bills = new ArrayList<>();
}
