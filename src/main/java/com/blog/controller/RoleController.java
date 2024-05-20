package com.blog.controller;


import com.blog.request.AddRoleRequest;
import com.blog.request.FetchRoleRequest;
import com.blog.request.UpdateRoleRequest;
import com.blog.response.APIResponse;
import com.blog.response.AddRoleResponse;
import com.blog.response.FetchRoleResponse;
import com.blog.response.UpdateRoleResponse;
import com.blog.service.RoleService;
import com.blog.utils.BlogAppConstants;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/add-role")
    public ResponseEntity<APIResponse> AddRole(@Valid @RequestBody AddRoleRequest request){
        AddRoleResponse data = this.roleService.createRole(request);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_CREATED,BlogAppConstants.STATUS_CREATED,BlogAppConstants.ROLE_CREATED,data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update-role")
    public ResponseEntity<APIResponse> UpdateRole(@Valid @RequestBody UpdateRoleRequest request){
        UpdateRoleResponse data = this.roleService.updateRole(request);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_SUCCESS,BlogAppConstants.STATUS_SUCCESS,BlogAppConstants.ROLE_UPDATED,data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getRoles")
    public ResponseEntity<APIResponse> fetchRoles(@Valid @RequestBody FetchRoleRequest request){
        FetchRoleResponse data = this.roleService.readAllRoles(request);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_SUCCESS,BlogAppConstants.STATUS_SUCCESS,BlogAppConstants.ROLE_FETCHED,data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete-role/{id}")
    public ResponseEntity<APIResponse> deleteRoles(@PathVariable("id") String roleId){
        this.roleService.deleteRole(roleId);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_SUCCESS,BlogAppConstants.STATUS_SUCCESS,BlogAppConstants.ROLE_DELETED);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
