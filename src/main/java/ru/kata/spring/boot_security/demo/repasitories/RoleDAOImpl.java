package ru.kata.spring.boot_security.demo.repasitories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
