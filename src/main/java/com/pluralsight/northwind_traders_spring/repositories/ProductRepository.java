package com.pluralsight.northwind_traders_spring.repositories;

import com.pluralsight.northwind_traders_spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends
        JpaRepository<Product, Long>,
        JpaSpecificationExecutor<Product> {

}
