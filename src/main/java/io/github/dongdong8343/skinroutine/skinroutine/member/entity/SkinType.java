package io.github.dongdong8343.skinroutine.skinroutine.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SkinType {
	NORMAL("중성"),
	DRY("건성"),
	OILY("지성"),
	COMBINATION("복합성"),
	DEHYDRATED_OILY("수분부족지성"),
	SENSITIVE("민감성");

	private final String koLabel;
}
