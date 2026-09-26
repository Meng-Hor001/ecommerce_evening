package com.edu.kh.ecommcer_evening.feature.Category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record CreateCategoryRequest (

        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50)
        String name,
        String description,
        String icon
){
}
