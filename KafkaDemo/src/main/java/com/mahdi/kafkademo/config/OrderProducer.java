package com.mahdi.kafkademo.config;

import com.mahdi.kafkademo.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderDto> kafkaTemplate;

    public void send(OrderDto order) {

        kafkaTemplate.send(
                "orders-topic",
                order.customerName(),
                order
        );

        System.out.println(
                "Commande envoyée : " + order
        );
    }
}