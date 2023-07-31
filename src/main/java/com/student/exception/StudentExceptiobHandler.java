package com.student.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// customize the way that the error is throw. 
// This is optional, but it allows you to centralize exception handling logic in one place. 
@Component
@ControllerAdvice
public class StudentExceptiobHandler {
    
    @ExceptionHandler(value = {StudentNotFoundException.class})
    public ResponseEntity<StudentException> handleApiRequestException(StudentNotFoundException e){

        StudentException notFoundException = new StudentException(
            e.getMessage(),
            e,
            HttpStatus.NOT_FOUND,
            ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(notFoundException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoStudentUpdatePossible.class) 
    public ResponseEntity<StudentException> handleUpdateException(NoStudentUpdatePossible e){

        StudentException updateException = new StudentException(
            e.getMessage(), 
            e, 
            HttpStatus.BAD_REQUEST, 
            ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(updateException, HttpStatus.BAD_REQUEST);
    }
}
