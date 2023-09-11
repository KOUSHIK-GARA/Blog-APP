package com.blog.request;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateUsersRequest {
    private String userId;
    private String name;
    private String password;
    private String role;
    private String status;
}
