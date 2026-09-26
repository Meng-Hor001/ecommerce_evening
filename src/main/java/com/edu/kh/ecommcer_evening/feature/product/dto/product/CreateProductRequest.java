package com.edu.kh.ecommcer_evening.feature.product.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CreateProductRequest(
        @NotBlank(message = "Name is Required")
        @Size(min = 1, max = 100)
        String name,

        @NotNull(message = "Price is Required")
        @Positive
        BigDecimal price,

        @NotNull(message = "Price is Required")
        @Positive
        Integer qty,


        String description,

        @NotNull(message = "Price is Required")
        @Positive
        Integer categoryId
){}