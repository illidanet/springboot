package com.example.service;

import com.example.repositories.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by illidanet on 2/22/17.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AccountServiceImpl accountServiceImpl;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account= accountServiceImpl.GetAccountByEmail(email);

        Set<GrantedAuthority> grantedAuthorityset=new HashSet<>();

        return new User(account.getEmail(),account.getPassword())
        return null;
    }
}
