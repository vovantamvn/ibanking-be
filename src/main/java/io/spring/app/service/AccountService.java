package io.spring.app.service;

import io.spring.app.dto.AccountData;

public interface AccountService {
    AccountData findById(long id);
}
