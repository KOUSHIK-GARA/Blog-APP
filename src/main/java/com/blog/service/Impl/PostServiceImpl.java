package com.blog.service.Impl;

import com.blog.entity.Category;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.exception.ResourceNotFoundException;
import com.blog.repository.CategoryRepo;
import com.blog.repository.PostRepo;
import com.blog.repository.UserRepo;
import com.blog.request.PostRequest;
import com.blog.response.PostResponse;
import com.blog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;
import java.util.stream.Collectors;

public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public PostResponse createPost(PostRequest postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(String.valueOf(userId))
                .orElseThrow(()-> new ResourceNotFoundException("User","User id ",userId));

        Category category = this.categoryRepo.findById(String.valueOf(categoryId))
                .orElseThrow(()-> new ResourceNotFoundException("Category"," Category id  ",categoryId));



        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setCategory(category);
        post.setUser(user);

        Post newPost = this.postRepo.save(post);
        return this.modelMapper.map(newPost, PostResponse.class);
    }

    @Override
    public PostResponse updatePost(PostRequest postDto, Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post","Post id ",postId));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(postDto.getImageName());

        Post updatedPost = this.postRepo.save(post);


        return this.modelMapper.map(updatedPost,PostResponse.class);
    }

    @Override
    public PostResponse getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post","Post id ",postId));

        return this.modelMapper.map(post,PostResponse.class);
    }

    @Override
    public PostResponse getAllPosts(Integer pageNumber, Integer pagesize, String sortBy, String sortDir) {
        Sort sort = null;
        if(sortDir.equalsIgnoreCase("asc"))
        {
            sort = Sort.by(sortBy).ascending();
        }
        else
        {
            sort = Sort.by(sortBy).descending();
        }

        Pageable p = PageRequest.of(pageNumber, pagesize, sort);

        Page<Post> pagePost = this.postRepo.findAll(p);
        List<Post> allPosts = pagePost.getContent();

        List<PostRequest> postDtos = allPosts.stream().map(post->this.modelMapper.map(post,PostRequest.class))
                .collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());

        return postResponse;
    }

    @Override
    public void deletePost(Integer postId) {
        Post  post = this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post","Post id ", postId));

        this.postRepo.delete(post);
    }

    @Override
    public List<PostResponse> getPostsByCategory(Integer categoryId) {
        Category category  = this.categoryRepo.findById(String.valueOf(categoryId))
                .orElseThrow(()-> new ResourceNotFoundException("Category"," Category id ",categoryId));
        List<Post> posts = this.postRepo.findByCategory(category);

        List<PostResponse> postlist = posts.stream().map(post->this.modelMapper.map(post,PostResponse.class))
                .collect(Collectors.toList());

        return postlist;
    }

    @Override
    public List<PostResponse> getPostsByUser(Integer userId) {
        User user = this.userRepo.findById(String.valueOf(userId))
                .orElseThrow(()-> new ResourceNotFoundException("User"," id ",userId));

        List<Post> posts = this.postRepo.findByUser(user);
        //System.out.println(posts.isEmpty());

        List<PostResponse> postsList = posts.stream().map(post->this.modelMapper.map(post,PostResponse.class))
                .collect(Collectors.toList());

        return postsList;
    }

    @Override
    public List<PostResponse> searchPosts(String keyword) {
        List<Post> posts = this.postRepo.findByTitleContaining(keyword);
        List<PostResponse> postslist = posts.stream().map(post->this.modelMapper.map(post,PostResponse.class))
                .collect(Collectors.toList());
        return postslist;
    }
}
