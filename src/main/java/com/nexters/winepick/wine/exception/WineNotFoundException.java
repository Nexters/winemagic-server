package com.nexters.winepick.wine.exception;

public class WineNotFoundException extends RuntimeException {
  public WineNotFoundException(Integer wineId) {
    super(wineId + " 해당 와인 정보를 찾을 수 없습니다.");
  }
}
