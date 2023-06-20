package com.intraway.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {
    private Long timestamp;
    private Integer status;
    private String error;
    private String exception;
    private String message;
    private String path;
}
