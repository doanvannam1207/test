package com.example.test.service.iplm;

import com.example.test.entity.Category;
import com.example.test.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryService iCategoryService;
    @Override
    public Category findById(Long id) {
        return iCategoryService.findById(id);
    }
}
