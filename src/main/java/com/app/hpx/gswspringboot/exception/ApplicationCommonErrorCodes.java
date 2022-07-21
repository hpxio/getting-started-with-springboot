package com.app.hpx.gswspringboot.exception;

import org.springframework.http.HttpStatus;

public enum ApplicationCommonErrorCodes {

	NAME_OF_AUTHOR(HttpStatus.BAD_REQUEST.value(),
			"Name of author in incorrect format or is null", HttpStatus.BAD_REQUEST.name()),
	YEAR_OF_PUBLISHING(HttpStatus.BAD_REQUEST.value(),
			"Year of Publishing in incorrect range (allowed 1900 - 2022)", HttpStatus.BAD_REQUEST.name());

	ApplicationCommonErrorCodes(int errorCode, String errorMessage, String errorType) {
		/* do nothing - to avoid instantiation */
	}

	private int errorCode;
	private String errorMessage;
	private String errorType;

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorType() {
		return errorType;
	}
}
