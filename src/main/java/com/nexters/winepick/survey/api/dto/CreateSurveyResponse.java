package com.nexters.winepick.survey.api.dto;

import com.nexters.winepick.wine.api.dto.WineResponse;
import com.nexters.winepick.wine.domain.Wine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@AllArgsConstructor
public class CreateSurveyResponse {
    private int id;

    public static CreateSurveyResponse of(Integer id) {
        return new CreateSurveyResponse(id);
    }
}
