package com.nexters.winepick.user.repository;

import com.nexters.winepick.user.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {
}
