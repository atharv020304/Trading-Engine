package com.exchange.trading.order.consumer;

import com.exchange.trading.order.event.OrderEvent;
import com.exchange.trading.order.service.OrderPersistenceService;
import com.exchange.trading.orderbook.OrderBookService;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {
    private final OrderBookService orderBookService;
    private final OrderPersistenceService orderPersistenceService;

    public OrderEventConsumer(OrderBookService orderBookService, OrderPersistenceService orderPersistenceService) {
        this.orderBookService = orderBookService;
        this.orderPersistenceService = orderPersistenceService;
    }

    public void consume(OrderEvent event)
    {
        System.out.println("Consuming OrderEvent: "+ event.getOrderId());

        orderBookService.addOrder(event);

        orderPersistenceService.save(event);
    }
}
