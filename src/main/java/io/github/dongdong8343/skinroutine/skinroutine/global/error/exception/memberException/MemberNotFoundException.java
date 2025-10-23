package io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.memberException;

import io.github.dongdong8343.skinroutine.skinroutine.global.error.ErrorCode;
import io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.BusinessBaseException;

public class MemberNotFoundException extends BusinessBaseException {
	public MemberNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}

	public MemberNotFoundException() {
		super(ErrorCode.MEMBER_NOT_FOUND);
	}
}