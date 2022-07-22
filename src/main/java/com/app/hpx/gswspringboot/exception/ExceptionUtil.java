package com.app.hpx.gswspringboot.exception;

import org.springframework.http.HttpStatus;

public final class ExceptionUtil {

	private ExceptionUtil() {
		/* do nothing - to avoid instantiation of this static-member-only class */
	}

	/**
	 * @param e
	 *
	 * @return
	 */
	public static ApplicationCommonException buildApplicationCommonExceptionFromErrorCode(ApplicationCommonErrorCodes e) {
		ApplicationCommonException ex = new ApplicationCommonException();
		ex.setStatus(e.getStatus());
		ex.setExceptionType(e.getErrorType());
		ex.setExceptionCode(e.getErrorCode());
		ex.setExceptionMessage(e.getErrorMessage());
		return ex;
	}

	/**
	 * @param errorCode
	 * @param errorMessage
	 * @param errorType
	 *
	 * @return
	 */
	public static ApplicationCommonException buildApplicationCommonException(int errorCode, String errorMessage,
																																					 String errorType, HttpStatus status) {
		ApplicationCommonException ex = new ApplicationCommonException();
		ex.setExceptionType(errorType);
		ex.setExceptionCode(errorCode);
		ex.setExceptionMessage(errorMessage);
		ex.setStatus(status);
		return ex;
	}
}