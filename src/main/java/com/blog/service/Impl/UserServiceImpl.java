package com.blog.service.Impl;

import com.blog.payload.*;
import com.blog.repository.UserRepo;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public SignupResponse createUser(SignupRequest request) {
        return null;
    }

    @Override
    public UpdateUsersResponse updateUser(UpdateUsersRequest request) {
        return null;
    }

    @Override
    public FetchUsersResponse readAllUsers(FetchUsersRequest request) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }
}
