package ru.kata.spring.boot_security.demo.service;

import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
    private RoleService roleService;
    @Autowired
    public RoleServiceImpl(RoleService roleService) {
        this.roleService = roleService;
    }


    @Override
    public List<Role> getListRole() {
        return roleService.getListRole();
    }
}
