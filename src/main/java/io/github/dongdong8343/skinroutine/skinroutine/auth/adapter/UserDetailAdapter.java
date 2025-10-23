package io.github.dongdong8343.skinroutine.skinroutine.auth.adapter;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.github.dongdong8343.skinroutine.skinroutine.member.entity.Member;

public class UserDetailAdapter implements UserDetails {

	private final Member member;

	public UserDetailAdapter(Member member) {
		this.member = member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.member.getRoles()
			.stream()
			.map(role -> new SimpleGrantedAuthority(role.asAuthority()))
			.toList();
	}

	@Override
	public String getPassword() {
		return this.member.getPassword().getPassword();
	}

	@Override
	public String getUsername() {
		return this.member.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}