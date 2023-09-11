package com.blog.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRoleResponse {
    private String roleId;
    private String roleName;
    private String roleDescription;
}
