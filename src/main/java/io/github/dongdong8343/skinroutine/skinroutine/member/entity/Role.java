package io.github.dongdong8343.skinroutine.skinroutine.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
	ADMIN("ADMIN", "관리자"),
	USER("USER" , "사용자");

	private final String key;
	private final String name;

	public String asAuthority() {
		return "ROLE_" + key; // 예: ROLE_ADMIN, ROLE_USER
	}
}
