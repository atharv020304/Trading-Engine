package com.exchange.trading.order.service;

import com.exchange.trading.order.domain.OrderEntity;
import com.exchange.trading.order.domain.OrderPrimaryKey;
import com.exchange.trading.order.event.OrderEvent;
import com.exchange.trading.order.repository.OrderCassandraRepository;
import com.exchange.trading.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderPersistenceService {

    private final OrderCassandraRepository repository;

    public OrderPersistenceService(OrderCassandraRepository repository) {
        this.repository = repository;
    }

    public void save(OrderEvent event) {
        OrderPrimaryKey key = new OrderPrimaryKey();

        key.setSymbol(event.getSymbol());
        key.setCreatedAt(event.getTimestamp());
        key.setOrderId(event.getOrderId());

        OrderEntity entity = new OrderEntity();
        entity.setUserId(event.getUserId());
        entity.setKey(key);
        entity.setSide(event.getSide());
        entity.setPrice(event.getPrice());
        entity.setQuantity(event.getQuantity());
        entity.setStatus("NEW");

        repository.save(entity);

        System.out.println("Order persisted successfully"+ event.getOrderId());
    }
}
