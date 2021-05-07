package com.nexters.winepick.survey.service;

import com.nexters.winepick.survey.domain.Survey;
import com.nexters.winepick.survey.exception.SurveyNotFoundException;
import com.nexters.winepick.survey.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public Survey getSurvey(Integer surveyId) {
        return surveyRepository.findById(surveyId).orElseThrow(() -> new SurveyNotFoundException(surveyId));
    }

    public Survey createSurveyWithAnswers(Survey survey) {
        return surveyRepository.save(survey);
    }

    public List<Survey> getSurveyAll() {
        return this.surveyRepository.findAll();
    }
}
