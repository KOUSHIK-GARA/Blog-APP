package com.blog.exception;

import com.blog.response.APIResponse;
import com.blog.utils.BlogAppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<APIResponse> userNotFoundExceptionHandler(UserNotFoundException exception){
        List<Object> errors = new ArrayList<>();
        errors.add(exception.getClass());
        APIResponse response = new APIResponse(exception.getStatusCode(), BlogAppConstants.STATUS_FAILED,exception.getMessage(),errors);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<APIResponse> roleNotFoundExceptionHandler(RoleNotFoundException exception){
        List<Object> errors = new ArrayList<>();
        errors.add(exception.getClass());
        APIResponse response = new APIResponse(exception.getStatusCode(),BlogAppConstants.STATUS_FAILED,exception.getMessage(),errors);
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse> handleInvalidMethodArguments(MethodArgumentNotValidException exception){
        List<Object> errors = new ArrayList<>();
        Map<String, String> resp = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) ->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName,message);
        });
        errors.add(resp);
        APIResponse response = new APIResponse(BlogAppConstants.CODE_BAD_REQUEST, BlogAppConstants.STATUS_FAILED,BlogAppConstants.INVALID_REQUEST_BODY,errors);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
