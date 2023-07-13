package com.student.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class StudentException {
    
    private final String message;
    private final Throwable cause;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;
}
