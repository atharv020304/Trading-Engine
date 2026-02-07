package com.exchange.trading.order.repository;

import com.exchange.trading.order.persistence.ProcessedEventEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProcessedEventRepository extends CassandraRepository <ProcessedEventEntity, UUID>{
}
