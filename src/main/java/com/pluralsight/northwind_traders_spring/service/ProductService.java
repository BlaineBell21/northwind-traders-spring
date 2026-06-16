package com.pluralsight.northwind_traders_spring.service;

import com.pluralsight.northwind_traders_spring.model.Product;
import com.pluralsight.northwind_traders_spring.repositories.ProductRepository;
import com.pluralsight.northwind_traders_spring.utils.ProductSpecifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> searchProducts(
            String name,
            String category,
            BigDecimal minPrice,
            BigDecimal maxPrice){

        Specification<Product> spec = Specification.allOf();

        if(name != null) {
            spec = spec.and(ProductSpecifications.nameContains(name));
        }

        if( category != null) {
            spec = spec.and(ProductSpecifications.hasCategory(category));
        }

        if (minPrice != null) {
            spec = spec.and(ProductSpecifications.priceGreaterThan(minPrice));
        }

        if (maxPrice != null) {
            spec = spec.and(ProductSpecifications.priceLessThan(maxPrice));
        }

        if(minPrice != null && maxPrice != null) {
            spec = spec.and(ProductSpecifications.priceBetween(minPrice, maxPrice));
        }

        return productRepository.findAll(spec);
    }

    public Optional<Product> getProductsById(Long id){
        return productRepository.findById(id);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
