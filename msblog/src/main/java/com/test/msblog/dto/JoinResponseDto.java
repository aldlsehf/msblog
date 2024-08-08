package com.test.msblog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinResponseDto {

    private String msg;
    private int statusCode;

    public JoinResponseDto(String msg, int statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }
}
