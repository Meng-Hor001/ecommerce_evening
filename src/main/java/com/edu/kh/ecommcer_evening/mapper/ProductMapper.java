package com.edu.kh.ecommcer_evening.mapper;

import com.edu.kh.ecommcer_evening.domain.Product;
import com.edu.kh.ecommcer_evening.dto.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {


    public ProductResponse productToProductResponse(Product product){
        return ProductResponse
                .builder()
                .code(product.getCode())
                .name(product.getName())
                .price(product.getPrice())
                .qty(product.getQty())
                .description(product.getDescription())
                .isAvailable(product.getIsAvailable())
                .categoryName(product.getCategory().getName())
                .build();
    }
}
