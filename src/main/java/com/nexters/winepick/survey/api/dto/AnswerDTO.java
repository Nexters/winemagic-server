package com.nexters.winepick.survey.api.dto;

import com.nexters.winepick.survey.api.constant.AnswerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AnswerDTO {
    private String content;

    private AnswerType answerType;

    public AnswerDTO(String content, AnswerType answerType) {
        this.content = content;
        this.answerType = answerType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }
}
