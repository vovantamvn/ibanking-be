package io.spring.app.core.account;

public interface AccountService {
  AccountData findByUsername(String username);
}
