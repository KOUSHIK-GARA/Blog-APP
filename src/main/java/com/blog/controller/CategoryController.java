package com.blog.controller;

import com.blog.request.*;
import com.blog.response.*;
import com.blog.service.CategoryService;
import com.blog.utils.BlogAppConstants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add-category")
    public ResponseEntity<APIResponse> AddCategory(@Valid @RequestBody AddCategoryRequest request){
        AddCategoryResponse data = this.categoryService.createCategory(request);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_CREATED,BlogAppConstants.STATUS_CREATED,BlogAppConstants.CATEGORY_CREATED,data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update-category")
    public ResponseEntity<APIResponse> modifyCategory(@Valid @RequestBody UpdateCategoryRequest request){
        UpdateCategoryResponse data = this.categoryService.updateCategory(request);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_SUCCESS,BlogAppConstants.STATUS_SUCCESS,BlogAppConstants.CATEGORY_UPDATED,data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all-categories")
    public ResponseEntity<APIResponse> fetchRoles(@Valid @RequestBody FetchCategoryRequest request){
        FetchCategoryResponse data = this.categoryService.readAllCategories(request);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_SUCCESS,BlogAppConstants.STATUS_SUCCESS,BlogAppConstants.CATEGORY_FETCHED,data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<APIResponse> deleteRoles(@PathVariable("id") String categoryId){
        this.categoryService.deleteCategory(categoryId);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_SUCCESS,BlogAppConstants.STATUS_SUCCESS,BlogAppConstants.CATEGORY_DELETED);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
