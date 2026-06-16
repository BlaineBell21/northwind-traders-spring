package com.pluralsight.northwind_traders_spring.utils;

import com.pluralsight.northwind_traders_spring.model.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpecifications {

    public static Specification<Product> nameContains(String name) {
        return (table, query, criteria) ->
                criteria.like(criteria.lower(table.get("name")),
                        "%" + name.toLowerCase() + "%");
    }

    public static Specification<Product> hasCategory(String category){
        return (table, query, criteria) ->
                criteria.equal(table.get("category"), category);
    }

    public static Specification<Product> priceBetween(BigDecimal minPrice, BigDecimal maxPrice){
        return (table, query, criteria) ->
                criteria.between(table.get("price"), minPrice, maxPrice);
    }

    public static Specification<Product> priceGreaterThan(BigDecimal minPrice) {
        return (table, query, criteria) ->
                criteria.greaterThanOrEqualTo(table.get("price"), minPrice);
    }

    public static Specification<Product> priceLessThan(BigDecimal maxPrice) {
        return (table, query, criteria) ->
                criteria.lessThanOrEqualTo(table.get("price"), maxPrice);
    }

}
