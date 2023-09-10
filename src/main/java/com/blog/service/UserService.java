package com.blog.service;

import com.blog.entity.User;
import com.blog.payload.*;

import java.util.List;

public interface UserService {

    public SignupResponse createUser(SignupRequest request);
    public UpdateUsersResponse updateUser(UpdateUsersRequest request);
    public FetchUsersResponse readAllUsers(FetchUsersRequest request);
    public void  deleteUser(String userId);
}
