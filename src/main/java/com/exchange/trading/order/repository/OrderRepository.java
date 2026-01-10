package com.exchange.trading.order.repository;

import com.exchange.trading.order.domain.OrderEntity;

public interface OrderRepository {
    void Save(OrderEntity order);
}
