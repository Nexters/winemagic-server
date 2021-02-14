package com.nexters.winepick.user.service;

import com.nexters.winepick.user.api.dto.RenewAccessTokenDTO;
import com.nexters.winepick.user.api.dto.UserDTO;
import com.nexters.winepick.user.domain.User;
import com.nexters.winepick.user.exception.UserInvalidAccessTokenException;
import com.nexters.winepick.user.exception.UserNotFoundException;
import com.nexters.winepick.user.repository.UserRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public User createUserEntity(User user) {
        return this.userRepository.save(user);
    }

    public User getUserIdByAccessToken(String accessToken) {
        return this.userRepository.findUserByAccessToken(accessToken).orElseThrow(() -> new UserInvalidAccessTokenException(accessToken));
    }

    public User updateUserEntity(String accessToken, UserDTO userDTO) {
        User user = this.userRepository.findUserByAccessToken(accessToken)
                .orElseThrow(() -> new UserInvalidAccessTokenException(accessToken));

        user.setAccessToken(userDTO.getAccessToken());
        user.setPersonalityType(userDTO.getPersonalityType());

        return user;
    }
}
