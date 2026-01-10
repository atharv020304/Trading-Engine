package com.exchange.trading.order.repository.Impl;

import com.exchange.trading.order.domain.OrderEntity;
import com.exchange.trading.order.repository.OrderRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CassendraOrderRepository implements OrderRepository {

    @Override
    public void Save(OrderEntity order) {
        System.out.println("Order saved to Cassandra: " + order.getOrderId());
    }
}
