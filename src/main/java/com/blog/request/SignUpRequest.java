package com.blog.request;

import lombok.*;

@Getter
@Setter
@ToString
public class SignUpRequest {
    private String username;
    private String name;
    private String password;
    private String role;
    private String status;
}
