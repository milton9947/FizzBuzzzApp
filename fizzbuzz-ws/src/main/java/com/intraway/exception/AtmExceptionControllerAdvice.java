package com.intraway.exception;

import com.intraway.exception.types.BadRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AtmExceptionControllerAdvice {

    @ExceptionHandler(value = BadRequest.class)
    public ResponseEntity<ExceptionResponse> badRequest(BadRequest exception) {
        return buildResponseException(HttpStatus.BAD_REQUEST, exception);
    }

    private ResponseEntity<ExceptionResponse> buildResponseException(
            HttpStatus httpStatus, BadRequest exception){
        return new ResponseEntity<>(
                ExceptionResponse.builder()
                .timestamp(System.currentTimeMillis())
                .status(httpStatus.value())
                .error(exception.getError())
                .exception(exception.getClass().getName())
                .message(exception.getMessage())
                .path(exception.getPath())
                .build(),
                httpStatus
        );
    }
}
