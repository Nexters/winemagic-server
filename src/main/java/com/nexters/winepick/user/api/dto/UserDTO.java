package com.nexters.winepick.user.api.dto;

import com.nexters.winepick.constant.PersonalityType;
import java.math.BigInteger;
import lombok.Getter;

@Getter
public class UserDTO {
    private BigInteger userId;
    private PersonalityType personalityType;
    private String accessToken;
}
