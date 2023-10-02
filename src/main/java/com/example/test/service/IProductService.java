package com.example.test.service;

import com.example.test.entity.Category;
import com.example.test.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {
    public Product save(Product product);
    public void delete(Long id);
    public List<Product> findByName(String name);
    public List<Product> filterByPrice(BigDecimal minPrice, BigDecimal maxPrice);
    public List<Product> findByCategory(Category category);
}
