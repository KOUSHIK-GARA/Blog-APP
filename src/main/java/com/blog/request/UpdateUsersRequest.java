package com.blog.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateUsersRequest {

    @NotNull(message = "userId must not be null")
    @NotBlank(message = "userId must not be blank")
    @NotEmpty(message = "userId must not be empty")
    private String userId;
    private String name;
    private String password;
    private String role;
    private String status;
}
