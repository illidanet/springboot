package com.example.comtroller;

import com.example.comtroller.form.AccountForm;
import com.example.repositories.entities.Account;
import com.example.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by j_chena on 2017/1/10.
 */
@Controller
public class AccountController extends WebMvcConfigurerAdapter {

    @Autowired
    private AccountService accountService;

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

    @GetMapping("/signup")
    public String singUp(Account account){
        return "signup";
    }


    @PostMapping("/signup")
    public String checkAccountInfo(@Valid AccountForm account, BindingResult bindingResult, HttpSession session){
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
        return "redirect:/results";
    }

//    @PostMapping("/login")
//    public String logIn(@Valid AccountForm account, BindingResult bindingResult, HttpSession session){
//        if (bindingResult.hasErrors()) {
//            return "login";
//        }
//        AccountForm userAccount = accountService.getAccountFormByEmail(account.getEmail());
//
//        if (new BCryptPasswordEncoder().encode(userAccount.getPassword()).equals(account.getPassword())) {
//            session.setAttribute("user", account.getEmail());
//            System.out.println(account.toString());
//            return "redirect:/results";
//        }
//
//        return "results_failed";
//    }

}
