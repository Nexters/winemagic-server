package com.nexters.winepick.survey.service;

import com.nexters.winepick.survey.api.dto.ResultResponse;
import com.nexters.winepick.survey.domain.Result;
import com.nexters.winepick.survey.exception.ResultNotFoundException;
import com.nexters.winepick.survey.repository.ResultRepository;
import com.nexters.winepick.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@AllArgsConstructor
@Service
public class ResultService {

  private ResultRepository resultRepository;
  private UserRepository userRepository;

  public ResultResponse getResult(String accessToken, Integer resultId) {
    Result result = resultRepository.findById(resultId)
        .orElseThrow(() -> new ResultNotFoundException());

    if (!ObjectUtils.isEmpty(accessToken)) {
      userRepository.findUserByAccessToken(accessToken)
          .ifPresent(user -> {
            user.setPersonalityType(result.getPersonalityType());
            userRepository.save(user);
          });
    }

    return ResultResponse.of(result);
  }

}
