package io.github.dongdong8343.skinroutine.skinroutine.global.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
	// Global 에러 (G_)
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "G_001", "잘못된 HTTP 메서드를 호출했습니다."),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "G_002", "서버 에러가 발생했습니다."),
	INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "G_003", "입력값이 유효하지 않습니다."),

	// Member 관련 에러(M_)
	MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "M_001", "유저를 찾을 수 없습니다."),
	DUPLICATE_EMAIL(HttpStatus.CONFLICT, "M_002", "이미 사용 중인 이메일입니다."),
	PASSWORD_TOO_SHORT(HttpStatus.BAD_REQUEST, "M_003", "비밀번호는 최소 8자 이상이어야 합니다."),
	PASSWORD_TOO_SIMPLE(HttpStatus.BAD_REQUEST, "M_004", "비밀번호는 대문자, 소문자, 숫자, 특수문자 중 2가지 이상을 조합해야 합니다."),
	PASSWORD_HAS_SEQUENCE(HttpStatus.BAD_REQUEST, "M_005", "비밀번호에 연속된 문자를 사용할 수 없습니다."),

	// Token 관련 에러 (T_)
	INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "T_001", "리프레시 토큰이 유효하지 않습니다."),
	INVALID_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED, "T_002", "엑세스 토큰이 유효하지 않습니다."),
	UNAUTHORIZED_REQUEST(HttpStatus.UNAUTHORIZED, "T_003", "인증이 필요합니다."),
	FORBIDDEN_REQUEST(HttpStatus.FORBIDDEN, "T_004", "해당 리소스에 접근할 권한이 없습니다.");

	private final HttpStatus status;
	private final String code;
	private final String message;
}