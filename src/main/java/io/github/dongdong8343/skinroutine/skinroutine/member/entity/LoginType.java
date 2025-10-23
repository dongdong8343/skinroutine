package io.github.dongdong8343.skinroutine.skinroutine.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LoginType {
	/*
	기본 로그인 : EMAIL
	카카오 로그인 : KAKAO
	네이버 로그인 : NAVER
	구글 로그인 : GOOGLE
 */

	EMAIL, NAVER, GOOGLE, KAKAO;
}
