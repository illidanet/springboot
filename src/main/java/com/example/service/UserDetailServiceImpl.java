package com.example.service;

import com.example.repositories.entities.Account;
import com.example.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by illidanet on 2/22/17.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountServiceImpl;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account= accountServiceImpl.getAccountByEmail(email);

        //Set<GrantedAuthority> grantedAuthorityset=new HashSet<>();

        return new User(account.getEmail(),account.getPassword(),
                AuthorityUtils.createAuthorityList(account.getRole().toString()));
    }
}
