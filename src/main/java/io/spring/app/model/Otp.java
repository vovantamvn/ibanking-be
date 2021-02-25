package io.spring.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Otp extends BaseEntity {
    @NotBlank
    private String content;

    @Column(nullable = false, updatable = false)
    private LocalDateTime expireAt;
}
