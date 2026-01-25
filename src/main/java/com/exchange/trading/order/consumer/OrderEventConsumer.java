package com.exchange.trading.order.consumer;

import com.exchange.trading.order.event.OrderEvent;
import com.exchange.trading.order.service.OrderPersistenceService;
import com.exchange.trading.orderbook.MatchResult;
import com.exchange.trading.orderbook.MatchingEngine;
import com.exchange.trading.orderbook.OrderBookService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {
    private final OrderBookService orderBookService;
    private final OrderPersistenceService orderPersistenceService;
    private final MatchingEngine matchingEngine;
    public OrderEventConsumer(OrderBookService orderBookService, OrderPersistenceService orderPersistenceService, MatchingEngine matchingEngine) {
        this.orderBookService = orderBookService;
        this.orderPersistenceService = orderPersistenceService;
        this.matchingEngine = matchingEngine;
    }
    @KafkaListener(topics = "order-events", groupId= "orderbook-group")
    public void consume(OrderEvent event)
    {
    MatchResult result = matchingEngine.tryMatch(event);

    if(result.isMatched()){
        System.out.println("Matched order id: " + result.getMatchedOrderId());
    }else {
        orderBookService.addOrder(event);
    }
    orderPersistenceService.save(event);
    }
}
