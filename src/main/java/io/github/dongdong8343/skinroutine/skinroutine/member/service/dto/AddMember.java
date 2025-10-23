package io.github.dongdong8343.skinroutine.skinroutine.member.service.dto;

import java.util.List;

import io.github.dongdong8343.skinroutine.skinroutine.member.entity.Member;
import io.github.dongdong8343.skinroutine.skinroutine.member.entity.SkinConcern;
import io.github.dongdong8343.skinroutine.skinroutine.member.entity.SkinType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class AddMember {
	@ToString
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		SkinType skinType;

		@Email
		@NotBlank
		String email;

		@NotBlank
		String password;

		@Size(min = 2, max = 20)
		String nickname;

		@Size(min = 2, max = 4)
		String name;

		List<SkinConcern> skinConcerns;
	}

	@Getter
	public static class Response {
		private final Long memberId;
		private final String name;

		public Response(Long memberId, String name) {
			this.memberId = memberId;
			this.name = name;
		}
	}

	public static Response toResponse(Member member) {
		return new Response(member.getMemberId(), member.getNickname());
	}
}