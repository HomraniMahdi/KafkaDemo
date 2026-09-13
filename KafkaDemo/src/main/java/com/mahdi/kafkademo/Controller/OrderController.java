package com.mahdi.kafkademo.Controller;

import com.mahdi.kafkademo.config.OrderProducer;
import com.mahdi.kafkademo.dto.OrderDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderProducer producer;

    @PostMapping
    public ResponseEntity<String> createOrder(
            @Valid @RequestBody OrderDto order) {

        producer.send(order);

        return ResponseEntity.ok("Commande envoyée");
    }
}