package com.blog.response;

import com.blog.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FetchUsersResponse {
    List<User> usersList;
}
