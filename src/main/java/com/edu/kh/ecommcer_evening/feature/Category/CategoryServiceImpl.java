package com.edu.kh.ecommcer_evening.feature.Category;

import com.edu.kh.ecommcer_evening.feature.Category.dto.CategoryResponse;
import com.edu.kh.ecommcer_evening.feature.Category.dto.CreateCategoryRequest;
import com.edu.kh.ecommcer_evening.feature.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public CategoryResponse createNew(CreateCategoryRequest categoryRequest) {

        Category category = categoryMapper.mapCreateCategoryRequestToCategory(categoryRequest);

        category = categoryRepository.save(category);
        return categoryMapper.CategoryToCategoryResponse(category);
    }

    @Override
    public Page<CategoryResponse> getCategory(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by(Sort.Direction.DESC,"id"));

        Page<Category> categories = categoryRepository.findAll(pageable);

        return categories.map(categoryMapper::CategoryToCategoryResponse);
    }

    @Override
    public void deleteById(Integer id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Category has been not found")
                );
        categoryRepository.delete(category);
    }
}
