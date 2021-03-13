package io.spring.app.service;

import io.spring.app.dto.AccountData;
import io.spring.app.exception.NotFoundException;
import io.spring.app.model.Account;
import io.spring.app.repository.AccountRepository;
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
  public AccountData findById(long id) {
    Optional<Account> optAccount = accountRepository.findById(id);
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
