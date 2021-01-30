package com.nexters.winepick.survey.api.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


public class SurveyDTO {
    @JsonProperty(value = "content")
    private String content;

    @JsonProperty(value = "answers")
    private List<AnswerDTO> answers;

    public SurveyDTO(String content, List<AnswerDTO> answers) {
        this.content = content;
        this.answers = answers;
    }

    public String getContent() {
        return content;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }
}
