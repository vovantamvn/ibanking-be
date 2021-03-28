package io.spring.app.api.verifyotp;

import lombok.Getter;

@Getter
public class VerifyRequest {
    private long billId;
    private String code;
}
