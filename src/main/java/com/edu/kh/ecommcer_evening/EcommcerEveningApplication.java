package com.edu.kh.ecommcer_evening;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class EcommcerEveningApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommcerEveningApplication.class, args);
    }

}
