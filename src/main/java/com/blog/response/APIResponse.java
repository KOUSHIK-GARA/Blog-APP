package com.blog.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class APIResponse {

    private Integer code;

    private String status;
    private String message;
    private Object response;
    private List<ErrorResponse> errors;


    public APIResponse(Integer code, String status, String message, List<ErrorResponse> errors) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public APIResponse(Integer code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public APIResponse(Integer code, String status, String message, Object response) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.response = response;
    }


}
