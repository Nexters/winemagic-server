package com.nexters.winepick.survey.service;

import com.nexters.winepick.survey.domain.Survey;
import com.nexters.winepick.survey.repository.SurveyRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

//    private Survey getSurvey() {
//        return Object;
//    }
//
//    private Survey createSurveyWithAnswers(Survey survey) {
//        return Object;
//    }
}
