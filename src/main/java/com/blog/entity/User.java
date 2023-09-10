package com.blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    private String userId;
    private String username;
    private String password;
    private String role;
    private String about;
}
