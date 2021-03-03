package com.nexters.winepick.survey.api.dto;

import com.nexters.winepick.constant.PersonalityType;
import com.nexters.winepick.survey.domain.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse {

  private PersonalityType personalityType;

  private String subDesc;

  private String description;

  private String keyword1;

  private String keyword2;

  private String matchWine;

  private String feature;

  private Integer score;

  public static ResultResponse of(Result result) {
    return new ResultResponse(result.getPersonalityType(), result.getSubDesc(),
        result.getDescription(), result.getKeyword1(), result.getKeyword2(), result.getMatchWine(),
        result.getFeature(), result.getScore());
  }

}
