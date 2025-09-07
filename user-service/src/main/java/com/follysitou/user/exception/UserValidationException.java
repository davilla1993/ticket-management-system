package com.follysitou.user.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserValidationException extends RuntimeException {

    private final String field;
    private final String value;

    public UserValidationException(String field, String value) {
        super(String.format("Username %s is invalid", field));
        this.field = field;
        this.value = value;
    }

    public UserValidationException(String message, String field, String value) {
        super(message);
        this.field = field;
        this.value = value;
    }
}
