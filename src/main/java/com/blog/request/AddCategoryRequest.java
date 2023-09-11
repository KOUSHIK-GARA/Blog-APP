package com.blog.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCategoryRequest {
    @NotNull(message = "category name cannot be null")
    @NotBlank(message = "category name cannot be blank")
    @NotEmpty(message = "category name cannot be empty")
    private String categoryName;

    @NotNull(message = "category description cannot be null")
    @NotBlank(message = "category description cannot be blank")
    @NotEmpty(message = "category description cannot be empty")
    private String categoryDescription;
}
