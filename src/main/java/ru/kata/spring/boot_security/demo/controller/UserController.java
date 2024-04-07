package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repasitories.UserDAO;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
@Controller
public class UserController {
    private UserService userService;
    private RoleServiceImpl roleService;

    public UserController(UserService userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;

    }


    @GetMapping(value = "/")
    public String start() {
        return "redirect:/user";
    }

    @GetMapping(value = "/user")
    public String showUser(Model model, Principal userDetails ){
        User user = userService.findByUsername(userDetails.getName());
        model.addAttribute("users",user);
        return "user";
    }
    @GetMapping(value = "/index")
    public String showForAllUsers(Model model, Role role){
        model.addAttribute("roles",roleService.getListRole());
        return "index";
    }
}
