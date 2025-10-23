package io.github.dongdong8343.skinroutine.skinroutine.member.validator;

import org.springframework.stereotype.Component;

import io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.memberException.DuplicateEmailException;
import io.github.dongdong8343.skinroutine.skinroutine.member.provider.MemberProvider;
import io.github.dongdong8343.skinroutine.skinroutine.member.service.dto.AddMember;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CreateMemberValidate {
	private final MemberProvider memberProvider;

	public void validate(AddMember.Request request) {
		checkEmail(request.getEmail());
	}

	public void checkEmail(String email) {
		if(memberProvider.checkEmail(email).isPresent()) {
			throw new DuplicateEmailException();
		}
	}
}
