package com.blog.controller;

import com.blog.request.PostRequest;
import com.blog.response.APIResponse;
import com.blog.response.PostResponse;
import com.blog.utils.BlogAppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blog.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController
{
    @Autowired
    private PostService postService;


    //create - POST

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest, @PathVariable("userId")Integer uid, @PathVariable("categoryId") Integer cid)
    {
        PostResponse createPost = this.postService.createPost(postRequest, uid, cid);
        return new ResponseEntity<PostResponse>(createPost, HttpStatus.CREATED);
    }


    //update - PUT

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostResponse> updatePost(@RequestBody PostRequest postRequest, @PathVariable("postId") Integer pid)
    {
        PostResponse updatedPostDto = this.postService.updatePost(postRequest, pid);
        return new ResponseEntity<PostResponse>(updatedPostDto, HttpStatus.OK);
    }






    //delete - DELETE
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable("postId") Integer pid)
    {
        this.postService.deletePost(pid);
        return new ResponseEntity<APIResponse>(new APIResponse(200,"success","Post deleted Successfully"), HttpStatus.OK);
    }





    //get all posts - GET

    @GetMapping("/posts/")
    public ResponseEntity<PostResponse>getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = BlogAppConstants.PAGE_NUMBER,required =false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = BlogAppConstants.PAGE_SIZE,required =false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = BlogAppConstants.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = BlogAppConstants.SORT_DIR, required = false) String sortDir)
    {
        return ResponseEntity.ok(this.postService.getAllPosts(pageNumber,pageSize,sortBy, sortDir));
    }


    //get posts by id - GET

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostResponse>getPostsById(@PathVariable("postId") Integer pid)
    {
        PostResponse posts = this.postService.getPostById(pid);

        return new ResponseEntity<PostResponse>(posts,HttpStatus.OK);
    }


    //get posts by user - GET

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostResponse>>getPostsByUser(@PathVariable("userId") Integer uid)
    {
        List<PostResponse> posts = this.postService.getPostsByUser(uid);

        return new ResponseEntity<List<PostResponse>>(posts,HttpStatus.OK);
    }


    //get posts by category - GET

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostResponse>>getPostsByCategory(@PathVariable("categoryId") Integer cid)
    {
        List<PostResponse> posts = this.postService.getPostsByCategory(cid);
        return new ResponseEntity<List<PostResponse>>(posts,HttpStatus.OK);
    }


    //search
    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostResponse>> searchPostByTitle(@PathVariable("keywords") String key)
    {
        List<PostResponse> result = this.postService.searchPosts(key);

        return new ResponseEntity<List<PostResponse>>(result,HttpStatus.OK);
    }







    //PostImage




    //Post Image Upload















}


