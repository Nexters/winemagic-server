package com.nexters.winepick.user.exception;

public class UserInvalidAccessTokenException extends RuntimeException {
    public UserInvalidAccessTokenException(String accessToken) {
        super(accessToken + " 인증되지 않은 토큰입니다.");
    }
}
