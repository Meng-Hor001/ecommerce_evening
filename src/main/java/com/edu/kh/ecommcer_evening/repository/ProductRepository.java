package com.edu.kh.ecommcer_evening.repository;

import com.edu.kh.ecommcer_evening.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

    Product findByCode(String code);
}
