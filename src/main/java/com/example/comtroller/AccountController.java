package com.example.comtroller;

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

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");

    }

    @GetMapping("/login")
    public String logIn(){
        return "login";
    }

    @PostMapping("/signup")
    public String checkAccountInfo(@Valid Account account, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form";
        }
        System.out.println(account.toString());
        return "redirect:/results";
    }
}
