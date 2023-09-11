package com.blog.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class UpdateUsersResponse {
    private String userId;
    private String name;
    private String username;
    private String password;
    private String role;
    private String status;
}
