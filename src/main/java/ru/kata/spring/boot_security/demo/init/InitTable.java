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
    public void loadData() {
        Role roleAdmin = new Role();
        roleAdmin.setRole("ROLE_ADMIN");
        Role roleUser = new Role();
        roleUser.setRole("ROLE_USER");
        Set<Role> listAdmin = new HashSet<>();
        listAdmin.add(roleUser);
//        listAdmin.add(roleAdmin);
        User user = new User("user", "Petr", 29, "user", listAdmin);
        userService.saveUser(user);

        listAdmin.clear();
        listAdmin.add(roleAdmin);
        user = new User("admin", "Sergey", 39, "admin", listAdmin);
        userService.saveUser(user);

    }
}
