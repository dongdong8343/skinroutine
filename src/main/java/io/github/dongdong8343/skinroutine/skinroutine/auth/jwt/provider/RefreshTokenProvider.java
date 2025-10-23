package io.github.dongdong8343.skinroutine.skinroutine.auth.jwt.provider;

import org.springframework.stereotype.Component;

import io.github.dongdong8343.skinroutine.skinroutine.auth.jwt.entity.RefreshToken;
import io.github.dongdong8343.skinroutine.skinroutine.auth.jwt.repository.RefreshTokenRepository;
import io.github.dongdong8343.skinroutine.skinroutine.global.error.exception.tokenException.InvalidRefreshTokenException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Component
@Log4j2
public class RefreshTokenProvider {
	private final RefreshTokenRepository refreshTokenRepository;

	public RefreshToken findByUuid(String uuid) {
		return refreshTokenRepository.findByUuid(uuid).orElse(null);
	}

	public RefreshToken findByRefreshToken(String refreshToken) {
		return refreshTokenRepository.findByRefreshToken(refreshToken)
			.orElseThrow(InvalidRefreshTokenException::new);
	}

	public void saveRefreshToken(RefreshToken refreshToken) {
		refreshTokenRepository.save(refreshToken);
	}

	public void deleteRefreshToken(String refreshToken) {
		refreshTokenRepository.deleteRefreshTokenByRefreshToken(refreshToken);
	}
}