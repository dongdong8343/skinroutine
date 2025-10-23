package io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.memberException;

import io.github.dongdong8343.skinroutine.skinroutine.global.error.ErrorCode;
import io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.BusinessBaseException;

public class DuplicateEmailException extends BusinessBaseException {
	public DuplicateEmailException(ErrorCode errorCode) {
		super(errorCode);
	}

	public DuplicateEmailException() {
		super(ErrorCode.DUPLICATE_EMAIL);
	}
}