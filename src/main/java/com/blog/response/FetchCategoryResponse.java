package com.blog.response;

import com.blog.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FetchCategoryResponse {
    List<Category> categoryList;
}
