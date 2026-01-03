package com.exchange.trading.order.controller;

import com.exchange.trading.order.dto.OrderRequest;
import com.exchange.trading.order.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) {
        UUID orderId = orderService.placeOrder(orderRequest);

        return ResponseEntity.ok("Order placed successfully. ID = " + orderId);
    }

}
