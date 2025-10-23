package io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.memberException;

import io.github.dongdong8343.skinroutine.skinroutine.global.error.ErrorCode;
import io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.BusinessBaseException;

public class PasswordTooShortException extends BusinessBaseException {
	public PasswordTooShortException(ErrorCode code) {
		super(code);
	}

	public PasswordTooShortException() {
		super(ErrorCode.PASSWORD_TOO_SHORT);
	}
}