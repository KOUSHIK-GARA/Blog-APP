package com.blog.response;

import java.util.*;

import com.blog.request.PostRequest;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class PostResponse
{
    private List<PostRequest> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;

    private boolean lastPage;
}
