package com.nexters.winepick.user.api.dto;

import lombok.Data;

@Data
public class RenewAccessTokenDTO {
    String expiredAccessToken;
    String newAccessToken;
}
