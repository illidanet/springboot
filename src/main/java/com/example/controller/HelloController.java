package com.example.controller;

import com.example.tutorials.pojos.Hello;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by artha on 2016/12/25.
 */
//@RestController
@Controller
public class HelloController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    @ResponseBody
    public Hello greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Hello(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
