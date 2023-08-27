package com.example.account.dto;

import com.example.account.aop.AccountLockIdInterface;
import com.example.account.type.TransactionResultType;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class CancelBalance {
    /**
     * Request 형식(json 형식)을 여기에 써두는 것이 좋음
     * {
     *     "transactionId" : "akfdjskawlkgoimckfjkw", //난수
     *     "accountNumber" : "1000000000"
     *     "amount" : 1000
     * }
     */
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request implements AccountLockIdInterface {
        @NotBlank
        private String transactionId;

        @NotBlank
        @Size(min = 10, max = 10)
        private String accountNumber;

        @NotNull
        @Min(10)
        @Max(1000_000_000)
        private Long amount;
    }

    /**
     * {
     *     "accountNumber" : "1234567890",
     *     "transactionResult" : "S",
     *     "transactionId" : "c2033b~~"
     *     "amount" : 1000,
     *     "transactedAt" : "2023-08-25T11:53:12.23456"
     * }
     */

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String accountNumber;
        private TransactionResultType transactionResult;
        private String transactionId;
        private Long amount;
        private LocalDateTime transactedAt;

        public static CancelBalance.Response from(TransactionDto transactionDto) {
            return CancelBalance.Response.builder()
                    .accountNumber(transactionDto.getAccountNumber())
                    .transactionResult(transactionDto.getTransactionResultType())
                    .transactionId(transactionDto.getTransactionId())
                    .amount(transactionDto.getAmount())
                    .transactedAt(transactionDto.getTransactedAt())
                    .build();
        }
    }
}
