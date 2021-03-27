package io.spring.app.core.account;

import io.spring.app.core.account.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findAccountByUsername(String username);
}
