package com.nexters.winepick.survey.api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;


@Getter
@AllArgsConstructor
public class SurveyDTO {
    private String content;
    private List<AnswerDTO> answers;
}
