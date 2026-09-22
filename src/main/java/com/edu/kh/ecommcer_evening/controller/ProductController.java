package com.edu.kh.ecommcer_evening.controller;


import com.edu.kh.ecommcer_evening.dto.CreateProductRequest;
import com.edu.kh.ecommcer_evening.dto.ProductResponse;
import com.edu.kh.ecommcer_evening.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping
    public Page<ProductResponse> getProducts(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "25") int pageSize
    ){
        return productService.getProducts(pageNumber, pageSize);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductResponse createNew(@Valid  @RequestBody CreateProductRequest createProductRequest){
        log.info("createProductRequest : {}", createProductRequest);
        return productService.createNew(createProductRequest);
    }
}
