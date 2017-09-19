package com.example.service.interfaces;

import com.example.controller.form.AccountForm;
import com.example.repositories.entities.Account;

/**
 * Created by illidanet on 2/27/17.
 */
public interface AccountService {

    void saveAccount(AccountForm form);

    AccountForm getAccountFormByEmail(String email);

    Account getAccountByEmail(String email);

    void autoLogin(String email,String password);

}
