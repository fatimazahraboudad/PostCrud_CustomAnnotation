package com.example.ProjectWithCustomAnnotation.exception;

public class PostNotExistInStock extends RuntimeException{
    public PostNotExistInStock() {
        super(ExceptionMessages.POST_NOT_EXIST.getMessage());
    }
}
