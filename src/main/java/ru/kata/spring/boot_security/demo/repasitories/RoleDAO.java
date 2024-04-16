package ru.kata.spring.boot_security.demo.repasitories;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleDAO {
    List<Role> getRolesList();

    Role findByRoleName(String name);

    void saveRole(Role role);
}
