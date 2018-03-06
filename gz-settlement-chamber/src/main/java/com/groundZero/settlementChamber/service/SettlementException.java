package com.groundZero.settlementChamber.service;

public class SettlementException extends Exception {

    public SettlementException() {
    }

    public SettlementException(Throwable cause) {
        super(cause);
    }

    public SettlementException(String message) {
        super(message);
    }

    public SettlementException(String message, Throwable cause) {
        super(message, cause);
    }
}
