package com.nexters.winepick.user.repository;

import com.nexters.winepick.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByAccessToken(String accessToken);
}
