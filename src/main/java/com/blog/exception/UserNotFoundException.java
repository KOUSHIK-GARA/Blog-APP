package com.blog.exception;

public class UserNotFoundException extends GlobalBlogAppException{
    private final String status;

    public UserNotFoundException(String message){
        super(message, 404);
        this.status = message;
    }
    public UserNotFoundException(String message, Integer statusCode){
        super(message, statusCode);
        this.status = message;
    }

    public String getStatus(){
        return this.status;
    }
}
