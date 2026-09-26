package com.edu.kh.ecommcer_evening.feature.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

    Product findByCode(String code);
}
