package com.app.hpx.gswspringboot.model.response;

import com.app.hpx.gswspringboot.model.ErrorDetailsModel;

/**
 * Base Response class to dertermine if there
 * are any errors in the response formation.
 * Will be used by Controllers in building
 * error ResponeEntity objects.
 */
public class BaseResponse {
    private ErrorDetailsModel errorDetailsModel;

    public ErrorDetailsModel getErrorDetailsModel() {
        return errorDetailsModel;
    }

    public void setErrorDetailsModel(ErrorDetailsModel errorDetailsModel) {
        this.errorDetailsModel = errorDetailsModel;
    }
}