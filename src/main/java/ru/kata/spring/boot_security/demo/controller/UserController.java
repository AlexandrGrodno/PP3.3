package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {



    @GetMapping(value = "/")
    public String start() {
        return "redirect:/user";
    }
    @GetMapping(value = "/admin")
    public String adminka(Model model){
        //model.addAttribute("users",userService.allUser());
        return "admin";
    }
    @GetMapping(value = "/user")
    public String showUser(){
        //model.addAttribute("users",userService.allUser());
        return "user";
    }
    @GetMapping(value = "/index")
    public String showForAllUsers(){
        //model.addAttribute("users",userService.allUser());
        return "index";
    }
}
