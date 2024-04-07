package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class AdminController {
    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/admin/user/id")
    public String editUser(@RequestParam (value = "id",defaultValue = "0") int id,Model model) {
        if (id > 0) model.addAttribute("users", userService.findUserById(id));
        return "editUser";
    }

//    @GetMapping(value = "/admin/user/id")
//    public String saveUser(@RequestParam(value = "id", defaultValue = "0")int  id, Model model) {
//        model.addAttribute("users", new User());
//        return "editUser";
//    }

    @PostMapping("/admin/user")
    public String saveUser(@Validated @ModelAttribute("users") User user, BindingResult bindingResult) {
        System.out.println(user);
        if (bindingResult.hasErrors())
            return "editUser";
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin")
    public String adminka(Model model){
        model.addAttribute("users", userService.findAll());
        return "admin";
    }
}
