package com.mahdi.kafkademo.config;

import com.mahdi.kafkademo.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    @KafkaListener(
            topics = "orders-topic",
            groupId = "order-group"
    )
    public void consume(OrderDto order) {

        log.info("""
                
                Commande reçue
                Id : {}
                Client    : {}
                Produit   : {}
                Quantité  : {}
                
                """,
                order.id(),
                order.customerName(),
                order.product(),
                order.quantity()
        );
    }
}