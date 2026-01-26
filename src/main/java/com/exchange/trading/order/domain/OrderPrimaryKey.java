package com.exchange.trading.order.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;

import java.time.Instant;
import java.util.UUID;

@PrimaryKeyClass
public class OrderPrimaryKey {
    private String symbol;
    private Instant createdAt;
    private UUID orderId;
}

