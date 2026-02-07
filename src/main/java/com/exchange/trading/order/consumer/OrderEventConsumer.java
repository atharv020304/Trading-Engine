package com.exchange.trading.order.consumer;

import com.exchange.trading.order.event.OrderEvent;
import com.exchange.trading.order.persistence.ProcessedEventEntity;
import com.exchange.trading.order.repository.ProcessedEventRepository;
import com.exchange.trading.order.service.OrderPersistenceService;
import com.exchange.trading.orderbook.MatchResult;
import com.exchange.trading.orderbook.MatchingEngine;
import com.exchange.trading.orderbook.OrderBookService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
public class OrderEventConsumer {
    private final OrderBookService orderBookService;
    private final OrderPersistenceService orderPersistenceService;
    private final MatchingEngine matchingEngine;
    private final ProcessedEventRepository processedEventRepository;

    public OrderEventConsumer(OrderBookService orderBookService, OrderPersistenceService orderPersistenceService, MatchingEngine matchingEngine, ProcessedEventRepository processedEventRepository) {
        this.orderBookService = orderBookService;
        this.orderPersistenceService = orderPersistenceService;
        this.matchingEngine = matchingEngine;
        this.processedEventRepository = processedEventRepository;
    }
    @KafkaListener(topics = "order-events", groupId= "orderbook-group")
    public void consume(OrderEvent event, Acknowledgment ack)
    {
        UUID eventID = event.getOrderId();
        if(processedEventRepository.existsById(eventID)){
            System.out.println("Duplicate Event Ignored");
            ack.acknowledge();
            return;
        }
    MatchResult result = matchingEngine.tryMatch(event);

    if(result.isMatched()){
        System.out.println("Matched order id: " + result.getMatchedOrderId());
    }else {
        orderBookService.addOrder(event);
    }
    orderPersistenceService.save(event);

    ProcessedEventEntity processed = new ProcessedEventEntity();
        processed.setEventId(eventID);
        processed.setProcessedAt(Instant.now());
        processedEventRepository.save(processed);

        ack.acknowledge();
        System.out.println("Event processed exactly once : " + processed.getEventId());
    }

}
