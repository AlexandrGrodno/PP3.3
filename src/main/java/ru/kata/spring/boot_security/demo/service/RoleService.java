package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getListRole();

    Role findRoleByName(String name);
    Role findRoleById(int id);

    void saveRole(Role role);
}
