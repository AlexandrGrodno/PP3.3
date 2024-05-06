package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


import java.security.Principal;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private UserService userService;


    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
    }

    @GetMapping(value = "api/user")
    public ResponseEntity<UserDTO> showUser(Principal principal) {

        return new ResponseEntity<>( userDTOMapper(userService.findByUsername(principal.getName()).get()), HttpStatus.OK);
    }


    public UserDTO userDTOMapper(User user){

        String roleString = user.getRoles().stream().map((Objects::toString)).collect(Collectors.joining(" ")).replace("ROLE_"," ");
        UserDTO userDTO= new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setRoles(user.getRoles());
        userDTO.setUserName(user.getUserName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAge(user.getAge());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(roleString);

        return userDTO;
    }

}
