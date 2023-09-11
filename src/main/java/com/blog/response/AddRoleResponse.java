package com.blog.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRoleResponse {
    private String roleId;
    private String roleName;
    private String roleDescription;
}
