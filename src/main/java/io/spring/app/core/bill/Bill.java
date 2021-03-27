package io.spring.app.core.bill;

import io.spring.app.core.BaseEntity;
import io.spring.app.core.account.Account;
import io.spring.app.core.opt.Otp;
import io.spring.app.core.student.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
public class Bill extends BaseEntity {
    @NotNull
    @ManyToOne
    private Account account;

    @NotNull
    @ManyToOne
    private Student student;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Otp otp;
}
