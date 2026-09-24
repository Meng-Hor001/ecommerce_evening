package com.edu.kh.ecommcer_evening.repository;

import com.edu.kh.ecommcer_evening.security.model.CustomUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<CustomUserDetails, Integer> {

    Optional<CustomUserDetails> findByUsername(String name);
}
