package com.blog.service;

import com.blog.request.AddRoleRequest;
import com.blog.request.FetchRoleRequest;
import com.blog.request.UpdateRoleRequest;
import com.blog.response.AddRoleResponse;
import com.blog.response.FetchRoleResponse;
import com.blog.response.UpdateRoleResponse;

public interface RoleService {
    public AddRoleResponse createRole(AddRoleRequest request);
    public UpdateRoleResponse updateRole(UpdateRoleRequest request);
    public FetchRoleResponse readAllRoles(FetchRoleRequest request);
    public void deleteRole(String roleId);
}
