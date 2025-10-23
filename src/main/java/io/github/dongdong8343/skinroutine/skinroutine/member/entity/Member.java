package io.github.dongdong8343.skinroutine.skinroutine.member.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import io.github.dongdong8343.skinroutine.skinroutine.global.base.BaseTimeEntity;
import io.github.dongdong8343.skinroutine.skinroutine.member.model.Password;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Member extends BaseTimeEntity {
	public static final boolean DEFAULT_SUSPENDED = false;
	public static final int DEFAULT_WARNING_COUNT = 0;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;

	@Enumerated(EnumType.STRING)
	private SkinType skinType;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private LoginType loginType;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "member_role", joinColumns = @JoinColumn(name = "member_id"))
	@Enumerated(EnumType.STRING)
	private List<Role> roles = new ArrayList<>();

	@Column(length = 40, nullable = false)
	private String email;

	@Column(length = 100, nullable = false)
	private Password password;

	@Column(length = 20, nullable = false)
	private String name;

	@Column(length = 20)
	private String nickname;

	@Column(nullable = false)
	private Boolean isSuspended;

	@Column(nullable = false)
	private Integer warningCount;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "member_skin_concern", joinColumns = @JoinColumn(name = "member_id"))
	@Enumerated(EnumType.STRING)
	private List<SkinConcern> skinConcerns = new ArrayList<>();

	// 일반 사용자 생성
	private Member(SkinType skinType, LoginType loginType, List<Role> roles, String email, Password password, String name, String nickname,
		Boolean isSuspended, Integer warningCount, List<SkinConcern> skinConcerns) {
		this.skinType = skinType;
		this.loginType = loginType;
		this.roles = roles;
		this.email = email;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.isSuspended = isSuspended;
		this.warningCount = warningCount;
		this.skinConcerns = skinConcerns;
	}

	public static Member createMemberByEmail(SkinType skinType, String email, Password password, String name, String nickname,
		List<SkinConcern> skinConcerns) {
		return new Member(skinType, LoginType.EMAIL, List.of(Role.USER), email, password, name, nickname, DEFAULT_SUSPENDED, DEFAULT_WARNING_COUNT, skinConcerns);
	}
}



