package io.github.dongdong8343.skinroutine.skinroutine.member.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.dongdong8343.skinroutine.skinroutine.member.entity.Member;
import io.github.dongdong8343.skinroutine.skinroutine.member.model.Password;
import io.github.dongdong8343.skinroutine.skinroutine.member.provider.MemberProvider;
import io.github.dongdong8343.skinroutine.skinroutine.member.service.dto.AddMember;
import io.github.dongdong8343.skinroutine.skinroutine.member.validator.CreateMemberValidate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	private final MemberProvider memberProvider;
	private final CreateMemberValidate createMemberValidate;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public AddMember.Response createMember(AddMember.Request request) {
		createMemberValidate.validate(request);

		Member member = memberProvider.createMember(
			Member.createMemberByEmail(request.getSkinType(), request.getEmail(), Password.fromRaw(bCryptPasswordEncoder, request.getPassword()),
				request.getName(), request.getNickname(), request.getSkinConcerns()));

		return AddMember.toResponse(member);
	}
}
