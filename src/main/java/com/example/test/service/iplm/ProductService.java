package com.example.test.service.iplm;

import com.example.test.entity.Category;
import com.example.test.entity.Product;
import com.example.test.repository.IProductRepository;
import com.example.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepository.findByName(name);
    }

    @Override
    public List<Product> filterByPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        return iProductRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return iProductRepository.findByCategory(category);
    }
}
