package com.eazybytes.accounts.mapper;

import com.eazybytes.accounts.dto.AccountDTO;
import com.eazybytes.accounts.entities.Account;

public class AccountMapper {
    public static AccountDTO mapToAccountsDto(Account accounts, AccountDTO accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Account mapToAccounts(AccountDTO accountsDto, Account accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
