package io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.memberException;

import io.github.dongdong8343.skinroutine.skinroutine.global.error.ErrorCode;
import io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.BusinessBaseException;

public class PasswordTooSimpleException extends BusinessBaseException {
	public PasswordTooSimpleException(ErrorCode code) {
		super(code);
	}

	public PasswordTooSimpleException() {
		super(ErrorCode.PASSWORD_TOO_SIMPLE);
	}
}