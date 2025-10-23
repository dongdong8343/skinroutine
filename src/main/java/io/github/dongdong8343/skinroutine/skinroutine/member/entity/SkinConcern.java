package io.github.dongdong8343.skinroutine.skinroutine.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SkinConcern {
	ACNE("여드름/트러블"),
	SENSITIVITY("민감성/자극"),
	DRYNESS("건조/수분부족"),
	OILINESS("과피지/개기름"),
	PIGMENTATION("기미/색소침착"),
	WRINKLES_ELASTICITY("주름/탄력저하"),
	PORES("모공"),
	BLACKHEADS("블랙헤드"),
	REDNESS("붉은기/홍조"),
	TEXTURE("피부결"),
	DULLNESS("칙칙함");

	private final String name;
}
