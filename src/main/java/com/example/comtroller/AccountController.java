package com.example.comtroller;

import com.example.imapper.AccountMapper;
import com.example.pojos.Account;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpSession;
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

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");

    }

    @GetMapping("/login")
    public String logIn(Account account){
        return "login";
    }

   @PostMapping("/signup")
    public String checkAccountInfo(@Valid Account account, BindingResult bindingResult, HttpSession session){
        if (bindingResult.hasErrors()) {
            return "login";
        }
        accountMapper.insert(account.getEmail(),account.getPassword());
        session.setAttribute("user",account.getEmail());
        return "redirect:/results";
    }

    @PostMapping("/login")
    public String logIn(@Valid Account account, BindingResult bindingResult, HttpSession session){
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Account userAccount = accountMapper.findByEmail(account.getEmail());

        if (userAccount != null && userAccount.getPassword().equals(account.getPassword())) {
            session.setAttribute("user", account.getEmail());
            System.out.println(account.toString());
            return "redirect:/results";
        }
        return "results_failed";
    }

}
