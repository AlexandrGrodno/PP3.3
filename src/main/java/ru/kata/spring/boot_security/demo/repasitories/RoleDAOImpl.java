package ru.kata.spring.boot_security.demo.repasitories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Transient;
import java.util.List;
@Repository
public class RoleDAOImpl implements RoleDAO {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    public RoleDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Role> getRolesList() {

        return em.createQuery("from Role").getResultList();
    }

    @Override

    public Role FindByRoleName(String name) {
        Query query = em.createQuery("Select r from Role r  where r.role=:Name");
        query.setParameter("Name",name);
        return (Role) query.getSingleResult();
    }

    @Override

    public void saveRole(Role role) {
      em.merge(role);
    }
}
