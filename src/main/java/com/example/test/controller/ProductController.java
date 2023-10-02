package com.example.test.controller;

import com.example.test.entity.Category;
import com.example.test.entity.Product;
import com.example.test.service.ICategoryService;
import com.example.test.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICategoryService iCategoryService;

    // Thêm sản phẩm
    @PostMapping("/")
    public Product addProduct(@RequestBody Product product) {
        return iProductService.save(product);
    }

    // Cập nhật sản phẩm
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return iProductService.save(product);
    }

    // Xoá sản phẩm
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        iProductService.delete(id);
    }

    // Tìm kiếm sản phẩm theo tên
    @GetMapping("/search")
    public List<Product> searchProductByName(@RequestParam String name) {
        return iProductService.findByName(name);
    }

    // Tìm kiếm sản phẩm theo khoảng giá
    @GetMapping("/filter")
    public List<Product> filterProductsByPrice(
            @RequestParam BigDecimal minPrice,
            @RequestParam BigDecimal maxPrice
    ) {
        return iProductService.filterByPrice(minPrice, maxPrice);
    }

    // Lấy danh sách sản phẩm theo danh mục
    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        Category category = iCategoryService.findById(categoryId);
        if (category != null) {
            return iProductService.findByCategory(category);
        } else {
            return new ArrayList<>();
        }
    }
}
