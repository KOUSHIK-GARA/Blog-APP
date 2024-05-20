package com.blog.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCategoryResponse {
    private String categoryId;
    private String categoryName;
    private String categoryDescription;
}
