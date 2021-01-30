package com.nexters.winepick.survey.api.dto;

import com.nexters.winepick.survey.api.constant.AnswerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class AnswerDTO {
    private String content;

    private AnswerType answerType;
}
