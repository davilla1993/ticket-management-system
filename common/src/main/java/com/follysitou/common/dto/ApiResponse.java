package com.follysitou.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;

    private String message;

    private T data;

    private LocalDateTime timestamp;


    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(true, "Success", data, LocalDateTime.now());
    }

    public static <T> ApiResponse<T> success(String message,T data) {
        return new ApiResponse<T>(true, message, data, LocalDateTime.now());
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<T>(false, message, null, LocalDateTime.now());
    }
}
