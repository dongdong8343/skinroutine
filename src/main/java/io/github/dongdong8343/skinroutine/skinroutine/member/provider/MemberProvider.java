package io.github.dongdong8343.skinroutine.skinroutine.member.provider;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.memberException.MemberNotFoundException;
import io.github.dongdong8343.skinroutine.skinroutine.member.entity.Member;
import io.github.dongdong8343.skinroutine.skinroutine.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberProvider {
	private final MemberRepository memberRepository;

	public Member loadMemberByEmail(String email) {
		return memberRepository.findByEmail(email)
			.orElseThrow(MemberNotFoundException::new);
	}

	public Optional<Member> checkEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	public Member createMember(Member member) {
		return memberRepository.save(member);
	}
}
