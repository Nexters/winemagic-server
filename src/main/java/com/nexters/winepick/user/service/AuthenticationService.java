package com.nexters.winepick.user.service;

import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.user.exception.UserInvalidAccessTokenException;
import com.nexters.winepick.user.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class AuthenticationService {
    private final UserRepository userRepository;

    public User authenticate(String accessToken) {
        return this.userRepository.findUserByAccessToken(accessToken).orElseThrow(() -> new UserInvalidAccessTokenException(accessToken));
    }
}
