package com.blog.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String userId;
    private String username;
    private String password;
    private String role;
    private String about;
}
