package com.blog.exception;

public class GlobalBlogAppException extends RuntimeException{
    private final Integer statusCode;

    public GlobalBlogAppException(String message){
        super(message);
        this.statusCode = 500;
    }
    public GlobalBlogAppException(String message, Throwable cause){
        super(message,cause);
        this.statusCode = 500;
    }

    public GlobalBlogAppException(String message, Integer statusCode){
        super(message);
        this.statusCode = statusCode;
    }

    public GlobalBlogAppException(String message, Throwable cause, Integer statusCode){
        super(message,cause);
        this.statusCode = statusCode;
    }

    public Integer getStatusCode(){
        return this.statusCode;
    }
}
