package io.github.dongdong8343.skinroutine.skinroutine.config.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.dongdong8343.skinroutine.skinroutine.config.error.exception.BusinessBaseException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ErrorResponse> handle(HttpRequestMethodNotSupportedException e) {
		return createErrorResponseEntity(ErrorCode.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(BusinessBaseException.class)
	protected ResponseEntity<ErrorResponse> handle(BusinessBaseException e) {
		return createErrorResponseEntity(e.getErrorCode());
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> handle(Exception e) {
		return createErrorResponseEntity(ErrorCode.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<ErrorResponse> createErrorResponseEntity(ErrorCode errorCode) {
		return new ResponseEntity<>(
			ErrorResponse.of(errorCode),
			errorCode.getStatus());
	}
}