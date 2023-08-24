package com.example.account.type;

import com.example.account.exception.AccountException;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND("사용자가 없습니다."),
    MAX_ACCOUNT_PER_USER_10("사용자의 계좌가 최대 갯수인 10개를 초과했습니다.");
    private String description;
}
