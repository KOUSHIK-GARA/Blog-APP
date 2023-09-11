package com.blog.response;

import com.blog.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FetchRoleResponse {
    private List<Role> rolesList;
}
