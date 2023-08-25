package com.example.account.type;

import com.example.account.exception.AccountException;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND("사용자가 없습니다."),
    ACCOUNT_NOT_FOUND("계좌가 없습니다."),
    USER_ACCOUNT_UN_MATCH("사용자의 계좌가 소유주와 다릅니다."),
    AMOUNT_EXCEED_BALANCE("거래 금액이 계좌 잔액 보다 큽니다."),
    ACCOUNT_ALREADY_UNREGISTERED("계좌가 이미 해지되어 있습니다."),
    BALANCE_NOT_EMPTY("해지할 계좌에 금액이 비어있지 않습니다."),
    MAX_ACCOUNT_PER_USER_10("사용자의 계좌가 최대 갯수인 10개를 초과했습니다.");
    private String description;
}
