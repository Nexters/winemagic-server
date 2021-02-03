package com.nexters.winepick.survey.api;

import com.nexters.winepick.base.BaseResponse;
import com.nexters.winepick.survey.api.dto.CreateSurveyResponse;
import com.nexters.winepick.survey.api.dto.SurveyDTO;
import com.nexters.winepick.survey.domain.Survey;
import com.nexters.winepick.survey.service.SurveyService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/survey")
@Data
public class SurveyController {

    private final SurveyService surveyService;
    private final ModelMapper modelMapper;

    @PostMapping(path = "/")
    public BaseResponse<CreateSurveyResponse> createSurvey(@RequestBody SurveyDTO surveyDTO) {
        return new BaseResponse<>(200, "0", this.surveyService.createSurveyWithAnswers(
                this.modelMapper.map(surveyDTO, Survey.class)));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public Optional<Survey> getSurvey(Long id) {
        return this.surveyService.getSurvey(id);
    }
}
