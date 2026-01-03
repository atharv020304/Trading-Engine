package com.exchange.trading.order.service;

import com.exchange.trading.order.domain.Order;
import com.exchange.trading.order.dto.OrderRequest;
import com.exchange.trading.order.event.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class OrderService {

    private static final String TOPIC = "order-events";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderService(KafkaTemplate<String, Object> kafkaTEmplate) {
        this.kafkaTemplate = kafkaTEmplate;
    }

        public UUID placeOrder(OrderRequest req) {

            UUID orderId = UUID.randomUUID();

            OrderEvent event = new OrderEvent();
            event.setEventId(UUID.randomUUID());
            event.setOrderId(orderId);
            event.setSymbol(req.getSymbol());
            event.setSide(req.getSide());
            event.setQuantity(req.getQuantity());
            event.setPrice(req.getPrice());
            event.setTimestamp(Instant.now());

            kafkaTemplate.send(TOPIC, req.getSymbol(), event);
            return orderId;
        }
}


