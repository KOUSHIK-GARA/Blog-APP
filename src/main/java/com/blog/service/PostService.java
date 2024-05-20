package com.blog.service;

import com.blog.request.PostRequest;
import com.blog.response.PostResponse;
import java.util.*;

public interface PostService
{
    PostResponse createPost(PostRequest postDto, Integer userId, Integer categoryId);
    PostResponse updatePost(PostRequest postDto, Integer postId);
    PostResponse getPostById(Integer postId);
    PostResponse getAllPosts(Integer pageNumber, Integer pagesize, String sortBy, String sortDir);
    void deletePost(Integer postId);

    //get all Posts by category
    List<PostResponse>getPostsByCategory(Integer categoryId);

    //get all Posts by user
    List<PostResponse> getPostsByUser(Integer userId);

    //search posts
    List<PostResponse> searchPosts(String keyword);

}
