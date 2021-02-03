package com.nexters.winepick.survey.api.dto;

import com.nexters.winepick.survey.api.constant.AnswerType;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class AnswerDTO {
    private String content;
    private AnswerType answerType;
}
