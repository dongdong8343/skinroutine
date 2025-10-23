package io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.memberException;

import io.github.dongdong8343.skinroutine.skinroutine.global.error.ErrorCode;
import io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.BusinessBaseException;

public class PasswordHasSequenceException extends BusinessBaseException {
	public PasswordHasSequenceException(ErrorCode code) {
		super(code);
	}

	public PasswordHasSequenceException() {
		super(ErrorCode.PASSWORD_HAS_SEQUENCE);
	}
}