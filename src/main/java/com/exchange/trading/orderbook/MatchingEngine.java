package com.exchange.trading.orderbook;

import com.exchange.trading.order.event.OrderEvent;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.StringReader;
import java.util.Set;

public class MatchingEngine {
    private final StringRedisTemplate redisTemplate;

    public MatchingEngine(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public MatchResult tryMatch(OrderEvent incomingOrder) {
        String oppositeSide = incomingOrder.getSide().equals("BUY")?"sell":"buy";
        String key = "orderbook:" + incomingOrder.getSymbol() + ":" + oppositeSide;

        Set<String> bestOrders =
                redisTemplate.opsForZSet().range(key, 0, 0);

        if(bestOrders == null || bestOrders.isEmpty()) {
            return new MatchResult(false,null);
        }

        String matchedOrderId = bestOrders.iterator().next();

        Double bestPrice = redisTemplate.opsForZSet().score(key, matchedOrderId);

        if(bestPrice == null) {
            return new MatchResult(false,null);
        }

        boolean priceMatch;

        if(incomingOrder.getSide().equals("BUY")) {
            priceMatch = incomingOrder.getPrice().doubleValue() >= bestPrice;
        } else {
            priceMatch = incomingOrder.getPrice().doubleValue() <= bestPrice;
        }

        if(!priceMatch) {
            return new MatchResult(false,null);
        }

        redisTemplate.opsForZSet().remove(key, matchedOrderId);

        return new MatchResult(true, java.util.UUID.fromString(matchedOrderId));
    }
}
