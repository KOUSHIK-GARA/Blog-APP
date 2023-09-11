package com.blog.controller;

import com.blog.request.FetchUsersRequest;
import com.blog.request.SignUpRequest;
import com.blog.request.UpdateUsersRequest;
import com.blog.response.*;
import com.blog.service.UserService;
import com.blog.utils.BlogAppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse> registerUser(@RequestBody SignUpRequest request){
        SignupResponse data = this.userService.createUser(request);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_CREATED,BlogAppConstants.STATUS_CREATED,BlogAppConstants.USER_CREATED,data);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update-user")
    public ResponseEntity<APIResponse> modifyUser(@RequestBody UpdateUsersRequest request){
        UpdateUsersResponse data = this.userService.updateUser(request);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_SUCCESS,BlogAppConstants.STATUS_SUCCESS,BlogAppConstants.USER_UPDATED,data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all-users")
    public ResponseEntity<APIResponse> fetchAllUsers(@RequestBody FetchUsersRequest request){
        FetchUsersResponse data = this.userService.readAllUsers(request);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_SUCCESS,BlogAppConstants.STATUS_SUCCESS,BlogAppConstants.USER_FETCHED,data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<APIResponse> removeUser(@PathVariable("id") String userId){
        this.userService.deleteUser(userId);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_SUCCESS,BlogAppConstants.STATUS_SUCCESS,BlogAppConstants.USER_DELETED);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
