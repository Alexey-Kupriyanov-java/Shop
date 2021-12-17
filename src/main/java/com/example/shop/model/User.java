package com.example.shop.model;

import lombok.*;
//import org.hibernate.Hibernate;

import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    //@NotEmpty(message = "*Please provide your name")
    private String name;

    @Column(name = "password")
    //@NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "email")
    //@Email(message = "*Please provide a valid Email")
    //@NotEmpty(message = "*Please provide your email")
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}