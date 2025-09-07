package com.follysitou.user.exception;


import lombok.*;

import java.io.Serial;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class BasedException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String code;
    private final String message;
    private final String detail;
    private final String field;
    private final String value;
}
