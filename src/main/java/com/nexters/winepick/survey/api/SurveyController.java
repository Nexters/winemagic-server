package com.nexters.winepick.survey.api;

import com.nexters.winepick.survey.domain.Survey;
import com.nexters.winepick.survey.service.SurveyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/survey")
public class SurveyController {

    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @RequestMapping(method= RequestMethod.POST, path = "/survey")
    public void createSurvey(@RequestBody Survey survey) {
        this.surveyService.createSurveyWithAnswers(survey);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/survey")
    public Optional<Survey> getSurvey(Long id) {
        return this.surveyService.getSurvey(id);
    }
}
