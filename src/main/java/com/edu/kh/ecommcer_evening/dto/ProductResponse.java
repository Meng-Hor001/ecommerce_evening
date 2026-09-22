package com.edu.kh.ecommcer_evening.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponse(
        String code,

        String name,

        BigDecimal price,

        Integer qty,

        String description,

        Boolean isAvailable,

        String categoryName
) {}
