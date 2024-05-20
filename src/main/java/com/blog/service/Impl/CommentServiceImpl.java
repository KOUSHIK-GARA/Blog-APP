package com.blog.service.Impl;

import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.exception.ResourceNotFoundException;
import com.blog.repository.CommentRepo;
import com.blog.repository.PostRepo;
import com.blog.repository.UserRepo;
import com.blog.request.CommentRequest;
import com.blog.response.CommentResponse;
import com.blog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CommentResponse createComment(CommentRequest request, Integer postId, Integer userId) {
        Post post = this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post","Post id ", postId));

        User user = this.userRepo.findById(String.valueOf(userId))
                .orElseThrow(()-> new ResourceNotFoundException("User"," id ",userId));

        System.out.println(userId);
        Comment comment = this.modelMapper.map(request, Comment.class);
        comment.setPost(post);
        comment.setUser(user);
        Comment savedComment = this.commentRepo.save(comment);
        return  this.modelMapper.map(savedComment,CommentResponse.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment id ", commentId));
        this.commentRepo.delete(comment);
    }
}
