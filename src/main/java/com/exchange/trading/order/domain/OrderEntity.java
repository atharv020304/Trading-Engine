package com.exchange.trading.order.domain;
//
//import java.math.BigDecimal;
//import java.time.Instant;
//import java.util.UUID;
//
//public class OrderEntity {
//
//    private UUID orderId;
//    private String userId;
//    private String symbol;
//    private String side;
//    private BigDecimal price;
//    private long quantity;
//    private String status;
//    private Instant createdAt;
//
//    public UUID getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(UUID orderId) {
//        this.orderId = orderId;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getSymbol() {
//        return symbol;
//    }
//
//    public void setSymbol(String symbol) {
//        this.symbol = symbol;
//    }
//
//    public String getSide() {
//        return side;
//    }
//
//    public void setSide(String side) {
//        this.side = side;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
//    public long getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(long quantity) {
//        this.quantity = quantity;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Instant getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Instant createdAt) {
//        this.createdAt = createdAt;
//    }
//}
//

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigDecimal;

@Table("orders_by_symbol")
public class OrderEntity{
    public OrderPrimaryKey getKey() {
        return key;
    }

    public void setKey(OrderPrimaryKey key) {
        this.key = key;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @PrimaryKey
    private OrderPrimaryKey key;

    private String userId;
    private String side;
    private BigDecimal price;
    private long quantity;
    private String status;
}
