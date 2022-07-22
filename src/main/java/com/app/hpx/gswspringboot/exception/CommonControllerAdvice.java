package com.app.hpx.gswspringboot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.hpx.gswspringboot.model.ErrorDetailsModel;

@ControllerAdvice
public class CommonControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(CommonControllerAdvice.class);

    @ExceptionHandler(ApplicationCommonException.class)
    protected ResponseEntity<Object> handleRuntimeException(ApplicationCommonException ex){
        LOG.info("Exception : {}", ex);

        ErrorDetailsModel err = new ErrorDetailsModel();
        err.setErrorCode(ex.getExceptionCode());
        err.setErrorType(ex.getExceptionType());
        err.setErrorMessage(ex.getExceptionMessage());
        return new ResponseEntity<>(err, ex.getStatus());
    }
}