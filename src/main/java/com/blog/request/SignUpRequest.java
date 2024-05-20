package com.blog.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
public class SignUpRequest {
    @Email(message="Email address is not valid ")
    private String username;
    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotEmpty(message="password cannot be empty")
    @Size(min=3, max=10, message = "Password must be minimum of 3 characters and maximum of 10 characters")
    private String password;
    @NotEmpty(message = "Role cannot be empty")
    private String role;
    @NotEmpty(message = "Status  cannot be empty")
    private String status;
}
