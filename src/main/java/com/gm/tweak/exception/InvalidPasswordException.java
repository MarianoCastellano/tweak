package com.gm.tweak.exception;

public class InvalidPasswordException extends Exception {
	private static final long serialVersionUID = 1738547957184352457L;

	private int errorCode;

	public InvalidPasswordException(String message) {
		super(message);
		this.errorCode = ErrorCode.INVALID_PASSWORD;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
