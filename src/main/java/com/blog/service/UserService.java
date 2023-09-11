package com.blog.service;

import com.blog.request.FetchUsersRequest;
import com.blog.request.SignUpRequest;
import com.blog.request.UpdateUsersRequest;
import com.blog.response.*;

public interface UserService {

    public SignupResponse createUser(SignUpRequest request);
    public UpdateUsersResponse updateUser(UpdateUsersRequest request);
    public FetchUsersResponse readAllUsers(FetchUsersRequest request);
    public void  deleteUser(String userId);
}
