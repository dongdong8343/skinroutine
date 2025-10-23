package io.github.dongdong8343.skinroutine.skinroutine.global.error.exception;

import io.github.dongdong8343.skinroutine.skinroutine.global.error.ErrorCode;

public class BusinessBaseException extends RuntimeException {
	private final ErrorCode errorCode;

	public BusinessBaseException(String message, ErrorCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public BusinessBaseException(ErrorCode code) {
		super(code.getMessage());
		this.errorCode = code;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}