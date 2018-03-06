package com.groundZero.settlementChamber.service;

import java.math.BigDecimal;

public interface ExternalPaymentSystemGateway {

    void tax(BigDecimal amount) throws SettlementException;

    void royalty(BigDecimal amount) throws SettlementException;

    void pay(BigDecimal amount, String key) throws SettlementException;
}
