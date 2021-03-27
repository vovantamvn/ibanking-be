package io.spring.app.core.account;

import io.spring.app.exception.NotFoundException;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
  private final AccountRepository accountRepository;
  private final ModelMapper modelMapper;

  @Override
  public AccountData findByUsername(String username) {
    Optional<Account> optAccount = accountRepository.findAccountByUsername(username);
    Account account = convertToAccount(optAccount);
    return convertToData(account);
  }

  private Account convertToAccount(Optional<Account> optAccount) {
    return optAccount.orElseThrow(NotFoundException::new);
  }

  private AccountData convertToData(Account account) {
    return modelMapper.map(account, AccountData.class);
  }
}
