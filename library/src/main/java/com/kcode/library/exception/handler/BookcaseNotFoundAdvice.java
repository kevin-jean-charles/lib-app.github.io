package com.kcode.library.exception.handler;

import com.kcode.library.exception.BookcaseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BookcaseNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(BookcaseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(BookcaseNotFoundException ex) {
        return ex.getMessage();
    }

}
