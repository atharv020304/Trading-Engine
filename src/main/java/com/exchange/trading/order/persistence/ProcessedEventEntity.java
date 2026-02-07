package com.exchange.trading.order.persistence;

import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Table("processed_events")
public class ProcessedEventEntity {

    private UUID eventId;
    private Instant processedAt;

}
