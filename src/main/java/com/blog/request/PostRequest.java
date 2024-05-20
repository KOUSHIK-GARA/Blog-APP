package com.blog.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class PostRequest {
    private Integer postId;

    private String title;

    private String content;

    private String imageName;

    private Date addedDate;


    private AddCategoryRequest category;

    private SignUpRequest user;


    private Set<CommentRequest> comments = new HashSet<>();
}
