package com.app.hpx.gswspringboot.exception;

public class ApplicationCommonException extends RuntimeException {
    private int exceptionCode;
    private String exceptionMessage;
    private String exceptionType;

    public ApplicationCommonException() {
        /* do nothing */
    }

    public ApplicationCommonException(int exceptionCode, String exceptionMessage, String exceptionType) {
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
        this.exceptionType = exceptionType;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(int exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }
}