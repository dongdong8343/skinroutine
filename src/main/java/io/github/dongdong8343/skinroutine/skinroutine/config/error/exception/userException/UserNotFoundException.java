package io.github.dongdong8343.skinroutine.skinroutine.config.error.exception.userException;

import io.github.dongdong8343.skinroutine.skinroutine.config.error.ErrorCode;
import io.github.dongdong8343.skinroutine.skinroutine.config.error.exception.BusinessBaseException;

public class UserNotFoundException extends BusinessBaseException {
	public UserNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}

	public UserNotFoundException() {
		super(ErrorCode.USER_NOT_FOUND);
	}
}