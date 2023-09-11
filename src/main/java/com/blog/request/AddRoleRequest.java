package com.blog.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRoleRequest {
    @NotNull(message = "role name cannot be null")
    @NotBlank(message = "role name cannot be blank")
    @NotEmpty(message = "role name cannot be empty")
    private String roleName;

    @NotNull(message = "role description cannot be null")
    @NotBlank(message = "role description cannot be blank")
    @NotEmpty(message = "role description cannot be empty")
    private String roleDescription;
}
