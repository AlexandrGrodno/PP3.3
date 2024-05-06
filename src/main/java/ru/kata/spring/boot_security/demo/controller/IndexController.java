package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {
    @GetMapping(value = "/admin")
    public String adminpanel() {
        return "adminpanel";
    }
    @GetMapping(value = "/user")
    public String userpanel() {
        return "userpanel";
    }
}
