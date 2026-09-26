package com.edu.kh.ecommcer_evening.feature.Category;

import com.edu.kh.ecommcer_evening.feature.Category.dto.CategoryResponse;
import com.edu.kh.ecommcer_evening.feature.Category.dto.CreateCategoryRequest;
import com.edu.kh.ecommcer_evening.feature.product.dto.product.ProductResponse;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CategoryResponse createNew(@Valid @RequestBody CreateCategoryRequest createCategoryRequest){
        return categoryService.createNew(createCategoryRequest);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping
    public Page<CategoryResponse> getProducts(
            @RequestParam (required = false, defaultValue = "0") int pageNumber,
            @RequestParam (required = false, defaultValue = "25") int pageSize
    ){
        return categoryService.getCategory(pageNumber, pageSize);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        categoryService.deleteById(id);
    }
}
