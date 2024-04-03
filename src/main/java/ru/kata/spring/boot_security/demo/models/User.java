package ru.kata.spring.boot_security.demo.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User implements UserDetails {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty( message = "Введите имя")
    @Size(min = 2, max = 15, message = "Введите правильное имя")
    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    @Email(message = "не правильный email")
    private String mail;

    @Column(name = "age")
    @Min(value = 0, message = "возраст нее может меньше  0")
    @Max(value = 120,  message = "возраст нее может больше  120 :)), но это не точно..")
    private int age;

    @Transient
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @Column(name = "roles")
    private Set<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
