package com.edu.kh.ecommcer_evening.service;


import com.edu.kh.ecommcer_evening.dto.product.CreateProductRequest;
import com.edu.kh.ecommcer_evening.dto.product.PatchProductRequest;
import com.edu.kh.ecommcer_evening.dto.product.ProductResponse;
import com.edu.kh.ecommcer_evening.dto.product.UpdateProductRequest;
import org.springframework.data.domain.Page;


public interface ProductService {

    ProductResponse getProductByCode(String code);

    ProductResponse createNew(CreateProductRequest createProductRequest);

    Page<ProductResponse> getProducts(int pageNumber , int pageSize);

    ProductResponse updateByCode(String code, UpdateProductRequest updateProductRequest);

    ProductResponse patchProductByCode(String code, PatchProductRequest patchProductRequest);
}
