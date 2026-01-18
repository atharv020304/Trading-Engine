package com.exchange.trading.orderbook;

import com.exchange.trading.order.event.OrderEvent;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderBookService {
    private final StringRedisTemplate redisTemplate;

    public OrderBookService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void addOrder(OrderEvent event){
        String key = "orderbook:" + event.getSymbol() + ":" + event.getSide().toLowerCase();

        double score = event.getSide().equals("BUY")
                ? -event.getPrice().doubleValue()
                : event.getPrice().doubleValue();

        redisTemplate.opsForZSet()
                .add(key, event.getOrderId().toString(), score);

        System.out.println("Order added to redis orderbook : "+key);
    }
}
