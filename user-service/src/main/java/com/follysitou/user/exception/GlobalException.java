package com.follysitou.user.exception;

import com.follysitou.user.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserValidationException.class)
    public ResponseEntity<ErrorResponse> handleUserValidationException(UserValidationException ex) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .message(ex.getMessage())
                    .errorCode("400")
                    .field(ex.getField())
                    .value(ex.getValue())
                    .timestamp(LocalDateTime.now())
                    .build();

            return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserValidationException.class)
    public ResponseEntity<ErrorResponse> handleRoleValidationException(RoleValidationException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(ex.getMessage())
                .errorCode("400")
                .field(ex.getField())
                .value(ex.getValue())
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
