package com.blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="users")
public class User {

    @Id
    private Integer userId;
    private String name;
    private String username;
    private String password;
    private String role;
    private String status;
}
