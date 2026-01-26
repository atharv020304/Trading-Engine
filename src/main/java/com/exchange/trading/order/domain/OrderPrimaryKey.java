package com.exchange.trading.order.domain;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@PrimaryKeyClass
public class OrderPrimaryKey implements Serializable {

    @PrimaryKeyColumn(name = "symbol", type = PrimaryKeyType.PARTITIONED)
    private String symbol;

    @PrimaryKeyColumn(name = "created_at", ordinal = 0)
    private Instant createdAt;

    @PrimaryKeyColumn(name = "order_id", ordinal = 1)
    private UUID orderId;

    // getters & setters


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }
}

