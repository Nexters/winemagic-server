package com.nexters.winepick.survey.api;

import com.nexters.winepick.base.BaseMsgJsonResponse;
import com.nexters.winepick.survey.api.dto.SurveyDTO;
import com.nexters.winepick.survey.domain.Survey;
import com.nexters.winepick.survey.service.SurveyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/survey")
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    private final ModelMapper modelMapper;

    public SurveyController(SurveyService surveyService, ModelMapper modelMapper) {
        this.surveyService = surveyService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(path = "/")
    public int createSurvey(@RequestBody SurveyDTO surveyDTO) {
        System.out.println(surveyDTO.getContent());
        System.out.println(this.modelMapper.map(surveyDTO, Survey.class));
        this.surveyService.createSurveyWithAnswers(this.modelMapper.map(surveyDTO, Survey.class));
        return 200;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public Optional<Survey> getSurvey(Long id) {
        return this.surveyService.getSurvey(id);
    }
}
