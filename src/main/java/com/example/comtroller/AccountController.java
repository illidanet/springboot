package com.example.comtroller;

import com.example.imapper.AccountMapper;
import com.example.pojos.Account;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by j_chena on 2017/1/10.
 */
@Controller
public class AccountController extends WebMvcConfigurerAdapter {


    private final AccountMapper accountMapper;

    public AccountController(AccountMapper accountMapper){
        this.accountMapper=accountMapper;
    }

//    public void setAccountMapper(AccountMapper accountMapper){
//        this.accountMapper=accountMapper;
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");

    }

    @GetMapping("/login")
    public String logIn(Account account){
        return "login";
    }

   @PostMapping("/signup")
    public String checkAccountInfo(@Valid Account account, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form";
        }
        accountMapper.insert(account.getEmail(),account.getPassword());
        System.out.println(account.toString());
        return "redirect:/results";
    }
}
