package com.blog.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorResponse {

    private String message;

    private String type;
}
