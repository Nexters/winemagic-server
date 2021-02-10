package com.nexters.winepick.survey.exception;

public class SurveyNotFoundException extends RuntimeException {
    public SurveyNotFoundException(Integer surveyId) {
        super(surveyId + " 해당 질문지 정보를 찾을 수 없습니다.");
    }
}
