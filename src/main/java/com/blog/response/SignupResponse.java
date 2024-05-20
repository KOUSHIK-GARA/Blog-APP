package com.blog.response;

import lombok.*;

@Getter
@Setter
public class SignupResponse {

    private String userId;
    private String name;
    private String username;
    private String password;
    private String role;
    private String status;
}
