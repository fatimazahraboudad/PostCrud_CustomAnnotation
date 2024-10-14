package com.example.ProjectWithCustomAnnotation.exception;

public class FieldEmptyException extends RuntimeException{
    public FieldEmptyException() {
        super(ExceptionMessages.FIELD_SHOULD_NOT_BE_EMPTY.getMessage());
    }
}
