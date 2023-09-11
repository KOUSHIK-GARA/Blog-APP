package com.blog.exception;

public class CategoryNotFoundException  extends GlobalBlogAppException{
    private final String status;

    public CategoryNotFoundException(String message) {
        super(message);
        this.status = message;
    }
    public CategoryNotFoundException(String message,Integer statusCode) {
        super(message,statusCode);
        this.status = message;
    }
    public String getStatus(){
        return this.status;
    }
}
