package io.github.dongdong8343.skinroutine.skinroutine.auth.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.dongdong8343.skinroutine.skinroutine.auth.jwt.entity.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
	Optional<RefreshToken> findByRefreshToken(String refreshToken);

	Optional<RefreshToken> findByUuid(String uuid);

	void deleteRefreshTokenByRefreshToken(String refreshToken);
}
