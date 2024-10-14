package com.example.ProjectWithCustomAnnotation.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ExceptionMessages {

    POST_NOT_EXIST("Post not exist."),
    FIELD_SHOULD_NOT_BE_EMPTY("Field should not be empty.");




    private final String message;



    public String getMessage() {
        return message;
    }

    public String getMessage(String... args) {
        return String.format(message, (Object[]) args);
    }
}
