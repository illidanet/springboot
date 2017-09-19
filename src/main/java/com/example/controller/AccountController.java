package com.example.controller;

import com.example.controller.form.AccountForm;
import com.example.repositories.entities.Account;
import com.example.service.interfaces.AccountService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by j_chena on 2017/1/10.
 */
@Controller
public class AccountController extends WebMvcConfigurerAdapter {

    @Autowired
    private AccountService accountService;

    private org.slf4j.Logger logger= LoggerFactory.getLogger(this.getClass());

//    public AccountController(AccountService accountService){
//        this.accountService = accountService;
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");

    }

    @GetMapping("/login")
    public String logIn(Account account){
        return "login";
    }

    @GetMapping("/registration")
    public String singUp(Account account){
        return "signup";
    }


    @PostMapping("/registration")
    public String checkAccountInfo(@Valid AccountForm account, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "login";
        }

        account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
        accountService.saveAccount(account);
        accountService.autoLogin(account.getEmail(),account.getPassword());
        return "redirect:/results";
    }

    @RequestMapping("/results")
    public String loginSuccess(){
        logger.info("log in success");
        return "results";
    }

    @RequestMapping("/results_failed")
    public String loginFailed(){
        logger.info("log in failed");
        return "results_failed";
    }
}
