package com.nexters.winepick.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class BaseResponse<T> {
    private int statusCode;
    private String message;
    private T data;
}
