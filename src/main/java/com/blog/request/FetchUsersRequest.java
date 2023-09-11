package com.blog.request;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FetchUsersRequest {
    private String userId;
    private String name;
    private String role;
    private String status;

}
