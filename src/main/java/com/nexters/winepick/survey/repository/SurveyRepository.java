package com.nexters.winepick.survey.repository;

import com.nexters.winepick.survey.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
