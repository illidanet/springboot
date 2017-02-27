package com.example.service.interfaces;

import com.example.comtroller.form.AccountForm;
import com.example.repositories.entities.Account;

/**
 * Created by illidanet on 2/27/17.
 */
public interface AccountService {

    void saveAccount(AccountForm form);

    AccountForm GetAccountFormByEmail(String email);

    Account GetAccountByEmail(String email);

}
