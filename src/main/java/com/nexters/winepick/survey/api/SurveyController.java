package com.nexters.winepick.survey.api;

import com.nexters.winepick.base.BaseResponse;
import com.nexters.winepick.survey.api.dto.SurveyDTO;
import com.nexters.winepick.survey.domain.Survey;
import com.nexters.winepick.survey.service.SurveyService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/survey")
@Data
public class SurveyController {

    private final SurveyService surveyService;
    private final ModelMapper modelMapper;

    @PostMapping(path = "/")
    public BaseResponse<Survey> createSurvey(@RequestBody SurveyDTO surveyDTO) {
        return new BaseResponse<>(200, "0", this.modelMapper.map(this.surveyService.createSurveyWithAnswers(
                this.modelMapper.map(surveyDTO, Survey.class)), Survey.class));
    }

    @GetMapping(path = "/{surveyId}")
    public BaseResponse<Survey> getSurvey(@PathVariable Integer surveyId) {
        return new BaseResponse<>(200, "0", this.modelMapper.map(this.surveyService.getSurvey(surveyId), Survey.class));
    }

    @GetMapping(path = "/")
    public BaseResponse<List<Survey>> getSurveyAll() {
        return new BaseResponse<>(200, "0", this.surveyService.getSurveyAll());
    }
}
