package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import com.example.account.dto.AccountDto;
import com.example.account.exception.AccountException;
import com.example.account.repository.AccountRepository;
import com.example.account.repository.AccountUserRepository;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static com.example.account.type.AccountStatus.*;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountUserRepository accountUserRepository;

    // /**하고 엔터 치면 자동으로 파라미터 생성됨
    /**
     *
     * 사용자가 있는지 조회
     * 계좌의 번호를 생성하고
     * 계좌를 저장하고, 그 정보를 넘김.
     */
    @Transactional
    public AccountDto createAccount(Long userId, Long initialBalance) {
        AccountUser accountUser = accountUserRepository.findById(userId)
                .orElseThrow(() -> new AccountException(ErrorCode.USER_NOT_FOUND)); // 커스텀 에러exception
        String newAccountNumber = accountRepository.findFirstByOrderByIdDesc()
                .map(account -> (Integer.parseInt(account.getAccountNumber())) + 1 +"")
                .orElse("1000000000");
   // 1. 일회용 변수는 지양.
//        Account saveAccount = accountRepository.save(
//                Account.builder()
//                        .accountUser(accountUser)
//                        .accountStatus(IN_USE)
//                        .accountNumber(newAccountNumber)
//                        .balance(initialBalance)
//                        .registeredAt(LocalDateTime.now())
//                        .build()
//        );
//        return AccountDto.fromEntity(saveAccount);

        // 2.
        return AccountDto.fromEntity(
                accountRepository.save(Account.builder()
                    .accountUser(accountUser)
                    .accountStatus(IN_USE)
                    .accountNumber(newAccountNumber)
                    .balance(initialBalance)
                    .registeredAt(LocalDateTime.now())
                    .build())
        );
    }

    @Transactional
    public Account getAccount(Long id) {
        if(id < 0){
            throw new RuntimeException("Minus");
        }
        return accountRepository.findById(id).get();
    }
}
