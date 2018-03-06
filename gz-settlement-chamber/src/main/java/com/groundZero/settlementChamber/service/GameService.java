package com.groundZero.settlementChamber.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public interface GameService {

    String raiseBid(String accountId, BigDecimal amount) throws SettlementException;

    void dropBid(String bidId) throws SettlementException;
    
    String startGame(Set<String> bids) throws SettlementException;

    void distribute(String gameId, Map<String,Integer> ticks) throws SettlementException;

}
