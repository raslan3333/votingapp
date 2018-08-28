package com.raslan.votingapp.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;

@Scope
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 40)
    private String username;
    @Column(unique = true)
    private String email;
    @Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private int age;
    @Column
    @Length(min = 6, max = 100)
    private String password;
    @Column
    private Date birthday;
    @Column(nullable = false)
    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

