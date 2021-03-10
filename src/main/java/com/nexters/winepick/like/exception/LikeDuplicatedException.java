package com.nexters.winepick.like.exception;

public class LikeDuplicatedException extends RuntimeException {

  public LikeDuplicatedException() {
    super("이미 좋아요한 와인입니다.");
  }
}
