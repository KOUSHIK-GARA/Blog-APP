package com.blog.service.Impl;

import com.blog.entity.Role;
import com.blog.exception.RoleNotFoundException;
import com.blog.repository.RoleRepo;
import com.blog.request.AddRoleRequest;
import com.blog.request.FetchRoleRequest;
import com.blog.request.UpdateRoleRequest;
import com.blog.response.AddRoleResponse;
import com.blog.response.FetchRoleResponse;
import com.blog.response.UpdateRoleResponse;
import com.blog.service.RoleService;
import com.blog.utils.BlogAppConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddRoleResponse createRole(AddRoleRequest request) {
        Role role = this.modelMapper.map(request,Role.class);
        Random rand = new Random();
        role.setRoleId(String.valueOf(rand.nextInt(100)));
        Role savedRole = this.roleRepo.save(role);
        return this.modelMapper.map(savedRole,AddRoleResponse.class);
    }

    @Override
    public UpdateRoleResponse updateRole(UpdateRoleRequest request) {
        Role role = this.roleRepo.findById(request.getRoleId()).orElseThrow(()-> new RoleNotFoundException(BlogAppConstants.ROLE_NOT_FOUND,BlogAppConstants.CODE_NOT_FOUND));
        if(request.getRoleName() != null && !request.getRoleName().isEmpty()){
            role.setRoleName(request.getRoleName());
        }
        if(request.getRoleDescription() != null && !request.getRoleDescription().isEmpty()){
            role.setRoleDescription(request.getRoleDescription());
        }
        Role updatedRole = this.roleRepo.save(role);
        return this.modelMapper.map(updatedRole,UpdateRoleResponse.class);
    }

    @Override
    public FetchRoleResponse readAllRoles(FetchRoleRequest request) {
        List<String> list = request.getRoleNames();
        List<Role> rolesList = new ArrayList<>();
        FetchRoleResponse fetchResponse = new FetchRoleResponse();
        for(String roleName : list){
            Role role = this.roleRepo.findByRoleName(roleName).orElseThrow(()-> new RoleNotFoundException(BlogAppConstants.ROLE_NOT_FOUND,BlogAppConstants.CODE_NOT_FOUND));
            rolesList.add(role);
        }
        fetchResponse.setRolesList(rolesList);
        return fetchResponse;
    }

    @Override
    public void deleteRole(String roleId) {
        Role role = this.roleRepo.findById(roleId).orElseThrow(()-> new RoleNotFoundException(BlogAppConstants.ROLE_NOT_FOUND,BlogAppConstants.CODE_NOT_FOUND));
        this.roleRepo.delete(role);
    }
}
