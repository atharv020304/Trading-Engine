package com.exchange.trading.orderbook;

import java.util.UUID;

public class MatchResult {

    private boolean matched;
    private UUID matchedOrderId;

    public MatchResult(boolean matched, UUID matchedOrderId) {
        this.matched = matched;
        this.matchedOrderId = matchedOrderId;
    }

    public boolean isMatched() {
        return matched;
    }

    public UUID getMatchedOrderId() {
        return matchedOrderId;
    }
}
