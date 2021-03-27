package io.spring.app.api.account;

import io.spring.app.core.account.AccountData;
import io.spring.app.core.account.AccountService;
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

  @GetMapping(path = "/{username}")
  public ResponseEntity<AccountData> findById(@PathVariable String username) {
    return ResponseEntity.ok(accountService.findByUsername(username));
  }
}
