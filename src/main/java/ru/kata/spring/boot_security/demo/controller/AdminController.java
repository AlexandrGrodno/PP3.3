package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller

public class AdminController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/admin/addUser")
    public String addUser(Model model){
        model.addAttribute("users",new User());
        model.addAttribute("role1",roleService.getListRole());
        return "editUser";
    }
    @GetMapping(value = "/admin/user/id")
    public String editUser(@RequestParam (value = "id",defaultValue = "0") int id,Model model) {
        if (id > 0) model.addAttribute("users", userService.findUserById(id));

        model.addAttribute("role1",roleService.getListRole());
        return "editUser";
    }

//    @GetMapping(value = "/admin/user/id")
//    public String saveUser(@RequestParam(value = "id", defaultValue = "0")int  id, Model model) {
//        model.addAttribute("users", new User());
//        return "editUser";
//    }

    @PostMapping("/admin/user")
    public String saveUser(@Validated @ModelAttribute("users") User user,
                           BindingResult bindingResult,@RequestParam(value = "roles",defaultValue = "ROLE_USER") List<String> roleNames) {

            Set<Role> role2 = roleNames.stream()
                    .map(roleService::findRoleByName)
                    .collect(Collectors.toSet());


        System.out.println("1111111111");
        user.setRoles(role2);
        //if (bindingResult.hasErrors()){
            //System.out.println(bindingResult.toString());
          //  return "editUser";}
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin")
    public String adminka(Model model){
        model.addAttribute("users", userService.findAll());
        return "admin";
    }
    @GetMapping(value = "/admin/deleteUser")
    public String deleteUser(@RequestParam(value = "id")int id) {

        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}
