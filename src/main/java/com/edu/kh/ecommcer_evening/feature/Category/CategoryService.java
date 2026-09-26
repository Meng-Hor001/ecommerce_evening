package com.edu.kh.ecommcer_evening.feature.Category;

import com.edu.kh.ecommcer_evening.feature.Category.dto.CategoryResponse;
import com.edu.kh.ecommcer_evening.feature.Category.dto.CreateCategoryRequest;
import org.springframework.data.domain.Page;

public interface CategoryService {

    CategoryResponse createNew(CreateCategoryRequest categoryRequest);

    Page<CategoryResponse> getCategory(int pageNumber, int pageSize);

    void deleteById(Integer id);
}
