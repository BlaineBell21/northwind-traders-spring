package com.pluralsight.northwind_traders_spring.repositories;

import com.pluralsight.northwind_traders_spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByPrice(BigDecimal price);

    List<Product> findProductByCategoryIgnoreCase(String category);

    List<Product> findProductByNameContainingIgnoreCase(String name);

    List<Product> findProductById(Long id);


}
