package com.follysitou.user.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoleValidationException extends RuntimeException {

    private final String field;

    private final String value;

    public RoleValidationException(String field, String value) {
        this.field = field;
        this.value = value;
    }
}
