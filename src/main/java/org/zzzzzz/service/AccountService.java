package org.zzzzzz.service;

import org.springframework.stereotype.Service;
import org.zzzzzz.dto.AccountDto;
import org.zzzzzz.form.AccountForm;

@Service
public interface AccountService {

    public AccountDto login(AccountForm accountForm);

}
