package io.spring.app.api.banking;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class BankingController {
    private final BankingService bankingService;

    @PostMapping(path = "/banking")
    public ResponseEntity<Long> banking(@Valid @RequestBody BankingRequest request) {
        return ResponseEntity.ok(bankingService.processBanking(request));
    }
}
