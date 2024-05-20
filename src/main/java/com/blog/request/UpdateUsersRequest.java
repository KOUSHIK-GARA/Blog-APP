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

    @NotNull(message = "userId cannot be null")
    @NotBlank(message = "userId cannot be blank")
    @NotEmpty(message = "userId canot be empty")
    private String userId;
    private String name;
    private String password;
    private String role;
    private String status;
}
