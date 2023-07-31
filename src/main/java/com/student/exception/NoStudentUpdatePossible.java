package com.student.exception;

public class NoStudentUpdatePossible extends RuntimeException {

    public NoStudentUpdatePossible(String message){
        super(message);
    }
    
    public NoStudentUpdatePossible(String message, Throwable cause){
        super(message, cause);
    }    
}
