package com.example.todoapi.service;

import com.example.todoapi.model.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);

    List<Category> getAllCategories();

}