package com.project.shopapp.services;

import com.project.shopapp.dtos.CategoryDTO;
import com.project.shopapp.models.Category;

import java.util.List;

public interface ICategoryService {
    Category createCategory(CategoryDTO category);
    Category getCategoryById(Long id);
    List<Category> getAllCategories(); //Lay ra tat ca category
    Category updateCategory(long categoryId, CategoryDTO category);
    void  deleteCategory(long id);
}
