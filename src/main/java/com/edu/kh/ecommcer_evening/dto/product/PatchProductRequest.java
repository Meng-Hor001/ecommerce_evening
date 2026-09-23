package com.edu.kh.ecommcer_evening.dto.product;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PatchProductRequest(
        @Size(min = 1, max = 100)
        String name,

        String description,

        @Positive
        BigDecimal price,

        @Positive
        Integer qty,

        @Positive
        Integer categoryId,

        Boolean isAvailable
) {
}
