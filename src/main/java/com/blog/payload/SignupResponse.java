package com.blog.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignupResponse {
    private String username;
    private String password;
    private String role;
    private String about;
}
