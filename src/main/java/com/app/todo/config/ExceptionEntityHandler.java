package com.app.todo.config;

import com.app.todo.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEntityHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleEventNotFound(NotFoundException exception){
        return ResponseEntity.notFound().build();
    }
}
