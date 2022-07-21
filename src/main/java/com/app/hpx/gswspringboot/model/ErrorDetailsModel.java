package com.app.hpx.gswspringboot.model;

public class ErrorDetailsModel {
    private int errorCode;
    private String errorMessage;
    private String errorType;

    public ErrorDetailsModel() {
        super();
    }

    public ErrorDetailsModel(int errorCode, String errorMessage, String errorType) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorType = errorType;
    }

    @Override
    public String toString() {
        return "ErrorDetailsModel [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", errorType="
                + errorType + "]";
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
}