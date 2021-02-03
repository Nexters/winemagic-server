package com.nexters.winepick.survey.api.dto;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Getter
@NoArgsConstructor
public class SurveyDTO {
    private String content;

    private List<AnswerDTO> answers;
}
