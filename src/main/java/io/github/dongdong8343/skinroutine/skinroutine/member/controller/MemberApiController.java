package io.github.dongdong8343.skinroutine.skinroutine.member.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.dongdong8343.skinroutine.skinroutine.member.service.MemberService;
import io.github.dongdong8343.skinroutine.skinroutine.member.service.dto.AddMember;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@RestController
public class MemberApiController {
	private final MemberService memberService;

	@PostMapping("/signup")
	public AddMember.Response emailSignup(@RequestBody @Valid AddMember.Request request) {
		return memberService.createMember(request);
	}
}
