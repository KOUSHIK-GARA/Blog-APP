package com.blog.payload;

import java.util.List;

public class APIResponse {

    private String code;

    private String status;
    private String message;
    private Object data;
    private List<ErrorResponse> errors;


    public APIResponse(String code, String status, String message, List<ErrorResponse> errors) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public APIResponse(String code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }


}
