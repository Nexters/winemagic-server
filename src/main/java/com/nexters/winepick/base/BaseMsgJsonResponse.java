package com.nexters.winepick.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class BaseMsgJsonResponse {
    private int statusCode;
    private String message;

    public BaseMsgJsonResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
