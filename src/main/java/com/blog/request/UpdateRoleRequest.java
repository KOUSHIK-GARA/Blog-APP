package com.blog.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRoleRequest {
    @NotNull(message = "roleId cannot be null")
    @NotBlank(message = "roleId cannot be blank")
    @NotEmpty(message = "roleId cannot be empty")
    private String roleId;
    private String roleName;
    private String roleDescription;

}
