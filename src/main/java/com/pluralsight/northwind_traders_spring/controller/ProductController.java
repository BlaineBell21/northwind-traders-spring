package com.pluralsight.northwind_traders_spring.controller;


import com.pluralsight.northwind_traders_spring.model.Product;
import com.pluralsight.northwind_traders_spring.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return productService.getProductsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public List<Product> searchProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice){
        return productService.searchProducts(category, name, minPrice, maxPrice);
    }


    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
