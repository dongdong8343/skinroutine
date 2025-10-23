package io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.tokenException;

import io.github.dongdong8343.skinroutine.skinroutine.global.error.ErrorCode;
import io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.BusinessBaseException;

public class InvalidRefreshTokenException extends BusinessBaseException {
	public InvalidRefreshTokenException(ErrorCode errorCode) {
		super(errorCode);
	}

	public InvalidRefreshTokenException() {
		super(ErrorCode.INVALID_REFRESH_TOKEN);
	}
}
