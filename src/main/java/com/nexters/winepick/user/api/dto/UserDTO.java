package com.nexters.winepick.user.api.dto;

import com.nexters.winepick.constant.GenderType;
import com.nexters.winepick.constant.PersonalityType;
import lombok.Data;

@Data
public class UserDTO {
    private String email;
    private String nickname;
    private int ageRange;
    private GenderType gender;
    private PersonalityType personalityType;
    private String accessToken;
}
