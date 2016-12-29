package com.example.com.example.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * Created by artha on 2016/12/25.
 */
//@RestController
@Controller
public class HelloController {
//    @RequestMapping("/")
//    @ResponseBody
//    public String index() {
//        return "Hello World!";
//    }


    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
