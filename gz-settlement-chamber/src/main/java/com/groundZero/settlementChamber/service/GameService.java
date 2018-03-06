package com.groundZero.settlementChamber.service;

import java.math.BigDecimal;

public interface GameService {

    String raiseBid(String accountId, BigDecimal amount) throws SettlementException;

    void dropBid(String bidId) throws SettlementException;

    String startGame(String bidId1, String bidId2, String bidId3) throws SettlementException;

    void distribute(String gameId, int ticks1, int ticks2, int ticks3) throws SettlementException;

}
