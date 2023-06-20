package com.intraway.exception.types;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BadRequest extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String error;
    private String message;
    private String path;
}
