package com.app.hpx.gswspringboot.exception;

import org.springframework.http.HttpStatus;

public enum ApplicationCommonErrorCodes {

	NAME_OF_AUTHOR(HttpStatus.BAD_REQUEST.value(),
			"Name of author in incorrect format or is null", HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST),
	YEAR_OF_PUBLISHING(HttpStatus.BAD_REQUEST.value(),
			"Year of Publishing in incorrect range (allowed 1900 - 2022)", HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST);

	ApplicationCommonErrorCodes(int errorCode, String errorMessage, String errorType, HttpStatus status) {
		this.status = status;
		this.errorCode = errorCode;
		this.errorType = errorType;
		this.errorMessage = errorMessage;
	}

	private int errorCode;
	private String errorMessage;
	private String errorType;
	private HttpStatus status;

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorType() {
		return errorType;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
