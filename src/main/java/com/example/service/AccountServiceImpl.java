package com.example.service;

import com.example.controller.form.AccountForm;
import com.example.repositories.entities.Account;
import com.example.repositories.entities.Role;
import com.example.repositories.imapper.AccountMapper;
import com.example.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by illidanet on 2/20/17.
 */
@Component
public class AccountServiceImpl implements AccountService {

    private AccountMapper mapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AccountServiceImpl(AccountMapper mapper){
        this.mapper=mapper;
    }

    public void saveAccount(AccountForm form){
        Account account=new Account();
        account.setRole(Role.user);
        account.setEmail(form.getEmail());
        account.setPassword(form.getPassword());
        mapper.insert(account);
    }

    public AccountForm getAccountFormByEmail(String email){
        AccountForm form=new AccountForm();
        Account account=mapper.findByEmail(email);
        form.setEmail(account.getEmail());
        form.setPassword(account.getPassword());
        return form;
    }

    public Account getAccountByEmail(String email){
        return mapper.findByEmail(email);
    }

    public void autoLogin(String email,String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);

        // generate session if one doesn't exist
        //request.getSession();

        //token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }

}
