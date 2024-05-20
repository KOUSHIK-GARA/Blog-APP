package com.blog.service;

import com.blog.request.AddCategoryRequest;
import com.blog.request.FetchCategoryRequest;
import com.blog.request.UpdateCategoryRequest;
import com.blog.response.AddCategoryResponse;
import com.blog.response.FetchCategoryResponse;
import com.blog.response.UpdateCategoryResponse;

public interface CategoryService {
    public AddCategoryResponse createCategory(AddCategoryRequest request);
    public UpdateCategoryResponse updateCategory(UpdateCategoryRequest request);
    public FetchCategoryResponse readAllCategories(FetchCategoryRequest request);
    public void deleteCategory(String categoryId);
}
