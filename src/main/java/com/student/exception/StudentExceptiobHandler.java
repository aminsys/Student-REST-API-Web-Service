package com.student.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// customize the way that the error is throw.
@Component
@ControllerAdvice
public class StudentExceptiobHandler {
    
    @ExceptionHandler(value = {StudentNotFoundException.class})
    public ResponseEntity<StudentException> handleApiRequestException(StudentNotFoundException e){
    
        HttpStatus serverError = HttpStatus.NOT_FOUND;

        StudentException apiException = new StudentException(
            e.getMessage(),
            e,
            serverError,
            ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiException, serverError);
    }
}
