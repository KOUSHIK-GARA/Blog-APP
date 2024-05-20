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
public class FetchUsersRequest {

    @NotNull(message = "userId cannot be null")
    @NotBlank(message = "userId cannot be blank")
    @NotEmpty(message = "userId cannot be empty")
    private Integer userId;
    private String name;
    private String role;
    private String status;

}
