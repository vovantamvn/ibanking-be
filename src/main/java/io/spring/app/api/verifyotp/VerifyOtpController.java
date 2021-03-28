package io.spring.app.api.verifyotp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VerifyOtpController {
    private final VerifyService verifyService;

    @PostMapping(path = "/banking/verify")
    public ResponseEntity<String> verify(@RequestBody VerifyRequest request) {
        verifyService.verify(request);
        return ResponseEntity.ok("Success!");
    }
}
