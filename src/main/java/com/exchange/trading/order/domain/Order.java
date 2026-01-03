package com.exchange.trading.order.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Order {
    private UUID orderId;
    private String userId;
    private String symbol;
    private String side; // B or S
    private BigDecimal price;
    private long quantity;
    private String status;
    private Instant createdAt;

    public Order()
    {

    }

    public Order(
            UUID orderId,
            String userId,
            String symbol,
            String side,
            BigDecimal price,
            long quantity,
            String status,
            Instant createdAt
    ){
        this.orderId = orderId;
        this.userId = userId;
        this.symbol = symbol;
        this.side = side;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSide() {
        return side;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}

