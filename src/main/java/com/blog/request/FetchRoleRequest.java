package com.blog.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FetchRoleRequest {
    @NotNull(message = "role names cannot be null")
    @NotBlank(message = "role names cannot be blank")
    @NotEmpty(message = "role names  cannot be empty")
    private List<String> roleNames;
}
