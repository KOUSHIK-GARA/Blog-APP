package com.blog.response;

import lombok.*;
import org.springframework.web.ErrorResponse;

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
    private List<Object> errors;


    public APIResponse(Integer code, String status, String message, List<Object> errors) {
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
