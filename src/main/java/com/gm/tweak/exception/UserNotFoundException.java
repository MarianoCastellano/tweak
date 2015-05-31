package com.gm.tweak.exception;

public class UserNotFoundException extends Exception {
	private static final long serialVersionUID = 1738547957184352457L;

	private int errorCode;

	public UserNotFoundException(String message) {
		super(message);
		this.errorCode = ErrorCode.USER_NOT_FOUND;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
