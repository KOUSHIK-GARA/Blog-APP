package com.blog.service.Impl;

import com.blog.entity.Category;
import com.blog.entity.User;
import com.blog.exception.CategoryNotFoundException;
import com.blog.exception.UserNotFoundException;
import com.blog.repository.CategoryRepo;
import com.blog.request.AddCategoryRequest;
import com.blog.request.FetchCategoryRequest;
import com.blog.request.UpdateCategoryRequest;
import com.blog.response.*;
import com.blog.service.CategoryService;
import com.blog.utils.BlogAppConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddCategoryResponse createCategory(AddCategoryRequest request) {
        Category category = this.modelMapper.map(request,Category.class);
        Random rand  =  new Random();
        category.setCategoryId(String.valueOf(rand.nextInt(10000) + 20000));
        Category savedCategory = this.categoryRepo.save(category);
        return this.modelMapper.map(savedCategory, AddCategoryResponse.class);
    }

    @Override
    public UpdateCategoryResponse updateCategory(UpdateCategoryRequest request) {
        Category category = this.categoryRepo.findById(request.getCategoryId()).orElseThrow(()-> new CategoryNotFoundException(BlogAppConstants.CATEGORY_NOT_FOUND,BlogAppConstants.CODE_NOT_FOUND));
        if(request.getCategoryName() != null && !request.getCategoryName().isEmpty()){
            category.setCategoryName(request.getCategoryName());
        }
        if(request.getCategoryDescription() != null && !request.getCategoryDescription().isEmpty()){
            category.setCategoryDescription(request.getCategoryDescription());
        }
        Category updatedCategory = this.categoryRepo.save(category);
        return this.modelMapper.map(updatedCategory, UpdateCategoryResponse.class);
    }

    @Override
    public FetchCategoryResponse readAllCategories(FetchCategoryRequest request) {
        FetchCategoryResponse fetchResponse = new FetchCategoryResponse();
        List<Category> categoriesList = this.categoryRepo.findAll();
        if(request.getCategoryId() != null && !request.getCategoryId().isEmpty()){
            categoriesList = categoriesList.stream().filter(c ->{
                return (c.getCategoryId() != null && c.getCategoryId().equals(request.getCategoryName()));
            }).collect(Collectors.toList());
        }
        if(request.getCategoryName() != null && !request.getCategoryName().isEmpty()){
            categoriesList = categoriesList.stream().filter(c ->{
                return (c.getCategoryName() != null && c.getCategoryName().equals(request.getCategoryName()));
            }).collect(Collectors.toList());
        }
        if(request.getCategoryDescription() != null && !request.getCategoryDescription().isEmpty()){
            categoriesList = categoriesList.stream().filter(c ->{
                return (c.getCategoryDescription() != null && c.getCategoryDescription().equals(request.getCategoryDescription()));
            }).collect(Collectors.toList());
        }
        fetchResponse.setCategoryList(categoriesList);
        return fetchResponse;
    }

    @Override
    public void deleteCategory(String categoryId) {
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new CategoryNotFoundException(BlogAppConstants.CATEGORY_NOT_FOUND,BlogAppConstants.CODE_NOT_FOUND));
        this.categoryRepo.delete(category);
    }
}
