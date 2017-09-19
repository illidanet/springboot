package com.example.controller;

import com.example.controller.form.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by artha on 2017/1/1.
 */
@Controller
public class PersonController extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");

    }

    @GetMapping("/show")
    public String showForm(PersonForm personForm){
        return "form";
    }

    @PostMapping("/show")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "form";
        }
        System.out.println(personForm.toString());
        return "redirect:/results";
    }


}
