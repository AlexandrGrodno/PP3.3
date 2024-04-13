package ru.kata.spring.boot_security.demo.init;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class InitTable {
    private RoleService roleService;
    private UserService userService;

    public InitTable(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void loadData(){
        Role roleAdmin = new Role();
        roleAdmin.setRole("ROLE_ADMIN");
        Role roleUser = new Role();
        roleUser.setRole("ROLE_USER");
//    roleService.saveRole(roleAdmin);
//    roleService.saveRole(roleUser);
        Set<Role> listAdmin = new HashSet<>();
        listAdmin.add(roleAdmin);
        User user = new User();
        user.setUserName("admin");
        user.setLastName("sakd");
        user.setAge(10);
        user.setPassword("1111");
        user.setRoles(listAdmin);
    userService.saveUser(user);
//        user.setRoles(listAdmin);
        listAdmin.clear();
        listAdmin.add(roleUser);
        User user1 = new User();
        user1.setUserName("admin1"); user1.setLastName("sakd");user1.setAge(10);user1.setPassword("1111");
        user1.setRoles(listAdmin);
    userService.saveUser(user1);

        //userService.saveUser(new User("admin","Inna",30,"admin",listAdmin));
    }
}
