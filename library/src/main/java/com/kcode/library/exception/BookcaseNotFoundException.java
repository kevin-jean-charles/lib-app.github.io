package com.kcode.library.exception;

public class BookcaseNotFoundException extends RuntimeException {
    public BookcaseNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
