package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repasitories.RoleDAO;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
        private RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> getListRole() {
        return roleDAO.getRolesList();
    }

    @Override
    public Role findRoleByName(String name) {
        roleDAO.FindByRoleName(name);
        return roleDAO.FindByRoleName(name);
    }
}
