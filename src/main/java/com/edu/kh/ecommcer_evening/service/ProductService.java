package com.edu.kh.ecommcer_evening.service;


import com.edu.kh.ecommcer_evening.dto.CreateProductRequest;
import com.edu.kh.ecommcer_evening.dto.ProductResponse;
import org.springframework.data.domain.Page;


public interface ProductService {

    ProductResponse createNew(CreateProductRequest createProductRequest);

    Page<ProductResponse> getProducts(int pageNumber , int pageSize);
}
