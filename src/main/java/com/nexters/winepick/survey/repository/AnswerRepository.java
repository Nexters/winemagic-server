package com.nexters.winepick.survey.repository;

import com.nexters.winepick.survey.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
