package com.mahdi.kafkademo.config;

import com.mahdi.kafkademo.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderDto> kafkaTemplate;

    public void send(OrderDto order) {
        OrderDto orderWithId = new OrderDto(
                UUID.randomUUID().toString(),
                order.customerName(),
                order.product(),
                order.quantity()
        );

        kafkaTemplate.send(
                "orders-topic",
                orderWithId.id(),
                orderWithId
        );

        System.out.println(
                "Commande envoyée : " + orderWithId
        );
    }
}