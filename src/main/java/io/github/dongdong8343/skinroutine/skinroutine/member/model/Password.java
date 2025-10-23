package io.github.dongdong8343.skinroutine.skinroutine.member.model;

import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.memberException.PasswordHasSequenceException;
import io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.memberException.PasswordTooShortException;
import io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.memberException.PasswordTooSimpleException;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@Getter
public class Password {
	// 최소 길이
	private static final int MIN_PASSWORD_LENGTH = 8;
	// 대/소문자/숫자/특수문자 중 2가지 이상 충족
	private static final int MIN_REQUIRED_TYPES = 2;
	// 특수문자 허용 목록
	private static final String SPECIALS = "!@#$%^&*()_+\\-={}|\\[\\]:\";'<>?,./`~";
	// 정규식(미리 컴파일)
	private static final Pattern UPPERCASE = Pattern.compile(".*[A-Z].*");
	private static final Pattern LOWERCASE = Pattern.compile(".*[a-z].*");
	private static final Pattern DIGIT     = Pattern.compile(".*\\d.*");
	private static final Pattern SPECIAL   = Pattern.compile(".*[" + SPECIALS + "].*");
	// 금지된 연속 문자열(소문자로 비교)
	private static final String[] BAD_SEQUENCES = {
		"abcdefghijklmnopqrstuvwxyz",
		"qwertyuiop", "asdfghjkl", "zxcvbnm",
		"0123456789"
	};
	// 연속으로 검사할 최소 길이
	private static final int SEQ_WINDOW = 4;

	private String password;

	private Password(String password) {
		this.password = password;
	}

	public static Password fromRaw(BCryptPasswordEncoder bCryptPasswordEncoder, String password) {
		validate(password);

		return new Password(bCryptPasswordEncoder.encode(password));
	}

	private static void validate(String password) {
		if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
			throw new PasswordTooShortException();
		}

		int typeCount = 0;
		if (UPPERCASE.matcher(password).matches()) typeCount++; // 대문자
		if (LOWERCASE.matcher(password).matches()) typeCount++; // 소문자
		if (DIGIT.matcher(password).matches())     typeCount++; // 숫자
		if (SPECIAL.matcher(password).matches())   typeCount++; // 특수문자

		if (typeCount < MIN_REQUIRED_TYPES) {
			throw new PasswordTooSimpleException();
		}

		// 연속 키보드 검사
		String lowerPassword = password.toLowerCase();
		for (String seq : BAD_SEQUENCES) {
			for (int i = 0; i <= seq.length() - SEQ_WINDOW; i++) {
				String subSeq = seq.substring(i, i + SEQ_WINDOW);
				if (lowerPassword.contains(subSeq)) {
					throw new PasswordHasSequenceException();
				}
			}
		}
	}
}
