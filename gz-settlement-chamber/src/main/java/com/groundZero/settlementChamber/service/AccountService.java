package com.groundZero.settlementChamber.service;

import java.math.BigDecimal;

public interface AccountService {

    String createAccount(String login, String password) throws SettlementException;

    BigDecimal dropAccount(String accountId) throws SettlementException;

    void deposit(String accountId, BigDecimal amount, double taxRate, double royaltyRate) throws SettlementException;

    void withdraw(String accountId, BigDecimal amount) throws SettlementException;
}
