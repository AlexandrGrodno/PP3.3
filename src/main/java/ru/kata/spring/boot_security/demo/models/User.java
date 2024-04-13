package ru.kata.spring.boot_security.demo.models;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User implements UserDetails {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Size(min = 2, max = 15, message = "Введите правильное имя")
    @Column(name = "username")
    private String username;

    @Column(name = "lastname")
    @NotEmpty( message = "Введите lastName")
    @Size(min = 2, max = 15, message = "Введите правильное имя")
    private String lastName;

    @Column(name = "age")
    @Min(value = 0, message = "возраст нее может меньше  0")
    @Max(value = 120,  message = "возраст нее может больше  120 :)), но это не точно..")
    private int age;

    @Column
    @Size(  min = 4, message = "пароль нее может меньше  4 символов")
    private String password;

    @ManyToMany(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.EXTRA)
    @Fetch(FetchMode.JOIN)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String username, String lastName, int age, String password, Set<Role> roles) {
            this.username = username;
            this.lastName = lastName;
            this.age = age;
            this.password = password;
            this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> role) {
        this.roles = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(username, user.username) && Objects.equals(lastName, user.lastName) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, lastName, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
