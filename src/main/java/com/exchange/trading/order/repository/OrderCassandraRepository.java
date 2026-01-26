package com.exchange.trading.order.repository;

import com.exchange.trading.order.domain.OrderEntity;
import com.exchange.trading.order.domain.OrderPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCassandraRepository extends CassandraRepository<OrderEntity, OrderPrimaryKey> {

}
