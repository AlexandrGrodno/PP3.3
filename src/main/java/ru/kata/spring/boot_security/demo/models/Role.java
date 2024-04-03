package ru.kata.spring.boot_security.demo.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    @Column
    private String role;

    @ManyToMany(mappedBy = "roles")
    @Transient
    private List<User> users;

    @Override
    public String getAuthority() {
        return null;
    }
}
