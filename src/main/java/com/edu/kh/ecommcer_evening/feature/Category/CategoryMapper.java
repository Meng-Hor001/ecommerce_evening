package com.edu.kh.ecommcer_evening.feature.Category;

import com.edu.kh.ecommcer_evening.feature.Category.dto.CategoryResponse;
import com.edu.kh.ecommcer_evening.feature.Category.dto.CreateCategoryRequest;
import com.edu.kh.ecommcer_evening.feature.product.Product;
import com.edu.kh.ecommcer_evening.feature.product.dto.product.ProductResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CategoryMapper {

    Category mapCreateCategoryRequestToCategory(CreateCategoryRequest categoryRequest);

    CategoryResponse CategoryToCategoryResponse(Category category);
}
