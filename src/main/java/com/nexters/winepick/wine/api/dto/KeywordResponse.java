package com.nexters.winepick.wine.api.dto;

import com.nexters.winepick.wine.domain.Keyword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KeywordResponse {

  private Integer id;

  private String searchWord;

  public static KeywordResponse of(Keyword keyword) {
    return new KeywordResponse(keyword.getId(), keyword.getSearchWord());
  }

}
