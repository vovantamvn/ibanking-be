package io.spring.app.controller;

import io.spring.app.dto.AccountData;
import io.spring.app.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<AccountData> findById(@PathVariable long id) {
        return ResponseEntity.ok(accountService.findById(id));
    }
}
