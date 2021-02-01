package com.nexters.winepick.base;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class BaseMsgJsonResponse {
    private int statusCode;
    private String message;
}
