package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dto.UserDTO;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<UserDTO> edit(@PathVariable  int id, Principal userDetails) {
        UserDTO userDTO = id < 1 ? userDTOMapper(userService.findByUsername(userDetails.getName()).get()) : userDTOMapper(userService.findUserById(id));
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/role")
    public ResponseEntity<List<Role>> getAllRoles() {
       return new ResponseEntity<>(roleService.getListRole(),HttpStatus.OK);
    }

    @PatchMapping("/user")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody UserDTO userDTO){
        userService.saveUser(userMapper(userDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<HttpStatus> addNewUser(@RequestBody UserDTO userDTO){
        userService.saveUser(userMapper(userDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

     @GetMapping(value = "/user")
     public ResponseEntity<List<UserDTO>> getAllUser(){
        return new ResponseEntity<>(userService.findAll().stream().map(x->userDTOMapper(x)).collect(Collectors.toList()), HttpStatus.OK);
     }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    private User userMapper(UserDTO userDTO){
        Set<Role> role2 = userDTO.getRoles().stream().map(x->"ROLE_"+x.getRole())
                .map(roleService::findRoleByName)
                .collect(Collectors.toSet());
        User user= new User();
        user.setId(userDTO.getId());
        user.setRoles(role2);
        user.setUserName(userDTO.getUserName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setAge(userDTO.getAge());
        user.setPassword(userDTO.getPassword());
        return user;
    }

     public UserDTO userDTOMapper(User user){
        String role2 = user.getRoles().stream().map((Objects::toString)).collect(Collectors.joining(" ")).replace("ROLE_"," ");
        UserDTO userDTO= new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setRoles(user.getRoles());
        userDTO.setUserName(user.getUserName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setAge(user.getAge());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(role2);
        return userDTO;
    }
}
