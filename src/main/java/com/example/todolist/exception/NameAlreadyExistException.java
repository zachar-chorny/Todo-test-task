package com.example.todolist.exception;

public class NameAlreadyExistException extends RuntimeException {

    public NameAlreadyExistException(String message) {
        super(message);
    }
}
