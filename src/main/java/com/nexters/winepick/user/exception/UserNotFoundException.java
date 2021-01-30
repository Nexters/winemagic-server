package com.nexters.winepick.user.exception;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(Integer userId) {
    super(userId + " 사용자 정보를 찾을 수 없습니다.");
  }

}
