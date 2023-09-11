package com.blog.exception;

public class RoleNotFoundException extends GlobalBlogAppException {
    private final String status;
    public RoleNotFoundException(String message,Integer statuscode) {
        super(message,statuscode);
        this.status = message;
    }
    public RoleNotFoundException(String message) {
        super(message,404);
        this.status = message;
    }

    public String getStatus(){
        return this.status;
    }
}
