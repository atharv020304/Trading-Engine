package com.exchange.trading.order.dto;

import java.math.BigDecimal;

public class OrderRequest {
    private String userId;
    private String symbol;
    private String side;
    private BigDecimal price;
    private long quantity;

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

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}
