package com.nexters.winepick.survey.api;

import com.nexters.winepick.base.BaseResponse;
import com.nexters.winepick.survey.api.dto.ResultResponse;
import com.nexters.winepick.survey.service.ResultService;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
@RequiredArgsConstructor
public class ResultController {

  private final ResultService resultService;

  @GetMapping("/{resultId}")
  public BaseResponse<ResultResponse> getResult(HttpServletRequest req, @PathVariable("resultId") Integer resultId) {
    String accessToken = req.getHeader(HttpHeaders.AUTHORIZATION);
    ResultResponse result = resultService.getResult(accessToken, resultId);
    return new BaseResponse<>(200, "0", result);
  }

}
