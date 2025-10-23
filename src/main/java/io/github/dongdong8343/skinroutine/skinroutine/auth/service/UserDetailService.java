package io.github.dongdong8343.skinroutine.skinroutine.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.dongdong8343.skinroutine.skinroutine.auth.adapter.UserDetailAdapter;
import io.github.dongdong8343.skinroutine.skinroutine.member.provider.MemberProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
// 스프링 시큐리티에서 사용자 정보 가져오는 인터페이스
public class UserDetailService implements UserDetailsService {
	private final MemberProvider memberProvider;

	@Override // 사용자 이름으로 사용자 정보 가져옴.
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return new UserDetailAdapter(memberProvider.loadMemberByEmail(email));
	}
}