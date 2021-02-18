package com.nexters.winepick.survey.exception;

public class ResultNotFoundException extends RuntimeException {
  public ResultNotFoundException() {
    super("결과를 찾을 수 없습니다.");
  }

}
