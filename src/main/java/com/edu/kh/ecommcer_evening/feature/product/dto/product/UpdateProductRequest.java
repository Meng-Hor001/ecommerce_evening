package com.edu.kh.ecommcer_evening.feature.product.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record UpdateProductRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 1, max = 100)
        String name,

        String description,

        @NotNull
        @Positive
        BigDecimal price,

        @NotNull
        @Positive
        Integer qty
) {
}
