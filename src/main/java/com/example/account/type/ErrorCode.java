package com.example.account.type;

import com.example.account.exception.AccountException;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND("사용자가 없습니다.");
    private String description;
}
