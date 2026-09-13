package com.mahdi.kafkademo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record OrderDto(
        @NotBlank
        String customerName,
        @NotBlank
        String product,
        @Positive
        Integer quantity) {
}
