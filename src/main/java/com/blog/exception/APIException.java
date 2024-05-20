package com.blog.exception;

import lombok.*;

@Getter
@Setter
public class APIException extends RuntimeException {

    public APIException(String message) {
        super(message);

    }

    public APIException() {
        super();

    }

}