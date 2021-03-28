package io.spring.app.core.opt;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import io.spring.app.core.BaseEntity;
import io.spring.app.core.bill.Bill;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Otp extends BaseEntity {
    @NotBlank
    private String content;

    @Column(nullable = false, updatable = false)
    private LocalDateTime expireAt;

    @OneToOne
    private Bill bill;
}
