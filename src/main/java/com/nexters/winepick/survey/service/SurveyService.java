package com.nexters.winepick.survey.service;

import com.nexters.winepick.survey.api.dto.CreateSurveyResponse;
import com.nexters.winepick.survey.domain.Survey;
import com.nexters.winepick.survey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Optional<Survey> getSurvey(Long surveyId) {
        return surveyRepository.findById(surveyId);
    }

    public CreateSurveyResponse createSurveyWithAnswers(Survey survey) {
        return CreateSurveyResponse.of(surveyRepository.save(survey).getId());
    }
}
