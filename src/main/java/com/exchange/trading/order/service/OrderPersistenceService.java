package com.exchange.trading.order.service;

import com.exchange.trading.order.domain.OrderEntity;
import com.exchange.trading.order.event.OrderEvent;
import com.exchange.trading.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderPersistenceService {

    private final OrderRepository repository;

    public OrderPersistenceService(OrderRepository repository) {
        this.repository = repository;
    }

    public void save(OrderEvent event) {
        OrderEntity order = new OrderEntity();
        order.setOrderId(event.getOrderId());
        order.setSymbol(event.getSymbol());
        order.setPrice(event.getPrice());
        order.setQuantity(event.getQuantity());
        order.setSide(event.getSide());
        order.setStatus("NEW");
        order.setCreatedAt(event.getTimestamp());

        repository.save(order);
    }

}
