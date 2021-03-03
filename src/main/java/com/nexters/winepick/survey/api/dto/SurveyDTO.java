package com.nexters.winepick.survey.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDTO {
    private Integer id;

    private String content;

    private String answerA;

    private String answerB;

}
