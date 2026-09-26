package com.edu.kh.ecommcer_evening.feature.product;

import com.edu.kh.ecommcer_evening.feature.product.dto.product.PatchProductRequest;
import com.edu.kh.ecommcer_evening.feature.product.dto.product.ProductResponse;
import com.edu.kh.ecommcer_evening.feature.product.dto.product.UpdateProductRequest;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category.name", target = "categoryName")
     ProductResponse productToProductResponse(Product product);

   void updateProductRequestToProduct(UpdateProductRequest updateProductRequest,
                                 @MappingTarget Product product);

   @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchProductRequestToProduct(PatchProductRequest patchProductRequest,
                                      @MappingTarget Product product);
}
