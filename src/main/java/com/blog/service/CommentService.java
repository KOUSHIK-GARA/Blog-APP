package com.blog.service;

import com.blog.request.CommentRequest;
import com.blog.response.CommentResponse;

public interface CommentService {
    CommentResponse createComment(CommentRequest request, Integer postId, Integer userId);
    void deleteComment(Integer commentId);
}
