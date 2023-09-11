package com.blog.service.Impl;

import com.blog.entity.User;
import com.blog.request.FetchUsersRequest;
import com.blog.request.SignUpRequest;
import com.blog.request.UpdateUsersRequest;
import com.blog.response.*;
import com.blog.repository.UserRepo;
import com.blog.service.UserService;
import com.blog.utils.BlogAppConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SignupResponse createUser(SignUpRequest request) {
       User user = this.modelMapper.map(request,User.class);
        Random rand  =  new Random();
        user.setUserId(String.valueOf(rand.nextInt(10000)));
        User savedUser = this.userRepo.save(user);
        return this.modelMapper.map(savedUser, SignupResponse.class);
    }

    @Override
    public UpdateUsersResponse updateUser(UpdateUsersRequest request) {
        User user = this.userRepo.findById(request.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
        if(request.getPassword() != null && !request.getPassword().isEmpty()){
            user.setPassword(request.getPassword());
        }
        if(request.getName() != null && !request.getName().isEmpty()){
            user.setName(request.getName());
        }
        if(request.getRole() != null && !request.getRole().isEmpty()){
            user.setRole(request.getRole());
        }
        if(request.getStatus() != null && !request.getStatus().isEmpty()){
            user.setStatus(request.getStatus());
        }
        User updatedUser = this.userRepo.save(user);
        return this.modelMapper.map(updatedUser,UpdateUsersResponse.class);
    }

    @Override
    public FetchUsersResponse readAllUsers(FetchUsersRequest request) {
        User user = this.userRepo.findById(request.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
        FetchUsersResponse fetchResponse = new FetchUsersResponse();
        List<User> usersList = this.userRepo.findAll();

        if(request.getName() != null && !request.getName().isEmpty()){
            usersList = usersList.stream().filter(u ->{
                return (u.getName() != null && u.getName().equals(request.getName()));
            }).collect(Collectors.toList());
        }
        if(request.getRole() != null && !request.getRole().isEmpty()){
            usersList = usersList.stream().filter(u ->{
                return (u.getRole() != null && u.getRole().equals(request.getRole()));
            }).collect(Collectors.toList());
        }
        if(request.getStatus() != null && !request.getStatus().isEmpty()){
            usersList = usersList.stream().filter(u ->{
                return (u.getStatus() != null && u.getStatus().equals(request.getStatus()));
            }).collect(Collectors.toList());
        }
        fetchResponse.setUsersList(usersList);
        return fetchResponse;
    }

    @Override
    public void deleteUser(String userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
        this.userRepo.delete(user);
    }
}
