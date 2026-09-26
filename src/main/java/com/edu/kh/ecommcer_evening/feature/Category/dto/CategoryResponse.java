package com.edu.kh.ecommcer_evening.feature.Category.dto;

import lombok.Builder;

@Builder
public record CategoryResponse(
        Integer id,
        String name,
        String description,
        String icon
) {
}
