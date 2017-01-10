package com.example.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by j_chena on 2017/1/10.
 */
@Controller
public class AccountController extends WebMvcConfigurerAdapter {

    @GetMapping("login")
    public String logIn(){
        return "login";
    }
}
