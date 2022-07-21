package com.app.hpx.gswspringboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public void handleRuntimeException(RuntimeException ex){
        
    }
    
}
