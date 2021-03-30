package io.spring.app.core.bill;

import io.spring.app.core.BaseEntity;
import io.spring.app.core.account.Account;
import io.spring.app.core.fee.Fee;
import io.spring.app.core.opt.Otp;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Setter
@Getter
public class Bill extends BaseEntity {
    @NotNull
    @ManyToOne
    private Account account;

    @NotNull
    @ManyToOne
    private Fee fee;

    @Positive
    private long cost;

    boolean isValid = true;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Otp otp;
}
