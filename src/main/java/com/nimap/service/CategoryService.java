package com.nimap.service;

import com.nimap.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category createCategory(Category category);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);

    Page<Category> getAllCategories(Pageable pageable);
}
