package com.blog.controller;

import com.blog.payload.APIResponse;
import com.blog.payload.FetchUsersRequest;
import com.blog.payload.SignupRequest;
import com.blog.payload.UpdateUsersRequest;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse> registerUser(@RequestBody SignupRequest request){
        return null;
    }

    @PutMapping("/update-user")
    public ResponseEntity<APIResponse> modifyUser(@RequestBody UpdateUsersRequest request){
        return null;
    }

    @GetMapping("/all-users")
    public ResponseEntity<APIResponse> fetchAllUsers(@RequestBody FetchUsersRequest request){
        return null;
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<APIResponse> removeUser(@PathVariable("id") String userId){
        return  null;
    }
}
