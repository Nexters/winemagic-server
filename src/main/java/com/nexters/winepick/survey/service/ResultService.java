package com.nexters.winepick.survey.service;

import com.nexters.winepick.survey.api.dto.ResultResponse;
import com.nexters.winepick.survey.domain.Result;
import com.nexters.winepick.survey.exception.ResultNotFoundException;
import com.nexters.winepick.survey.repository.ResultRepository;
import com.nexters.winepick.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class ResultService {

  private final ResultRepository resultRepository;
  private final UserRepository userRepository;

  public ResultResponse getResult(String accessToken, Integer resultId) {
    Result result = resultRepository.findById(resultId)
        .orElseThrow(ResultNotFoundException::new);

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
