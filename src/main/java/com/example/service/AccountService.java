package com.example.service;

import com.example.comtroller.form.AccountForm;
import com.example.repositories.entities.Account;
import com.example.repositories.imapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by illidanet on 2/20/17.
 */
@Component
public class AccountService {

    private AccountMapper mapper;

    public AccountService(AccountMapper mapper){
        this.mapper=mapper;
    }

    public void saveAccount(AccountForm form){
        Account account=new Account();
        account.setEmail(form.getEmail());
        account.setPassword(form.getPassword());
        mapper.insert(account);
    }

    public AccountForm GetAccountByEmail(String email){
        AccountForm form=new AccountForm();
        Account account=mapper.findByEmail(email);
        form.setEmail(account.getEmail());
        form.setPassword(account.getPassword());
        return form;
    }

}
