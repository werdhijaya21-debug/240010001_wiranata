package com.example.todoapi.controller;

import com.example.todoapi.dto.CategoryRequest;
import com.example.todoapi.model.Category;
import com.example.todoapi.service.CategoryService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {


    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    // POST /api/categories
    @PostMapping
    public ResponseEntity<Category> createCategory(
            @Valid @RequestBody CategoryRequest request
    ) {

        Category category = new Category();

        category.setName(request.getName());


        return new ResponseEntity<>(
                categoryService.createCategory(category),
                HttpStatus.CREATED
        );
    }



    // GET /api/categories
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {

        return ResponseEntity.ok(
                categoryService.getAllCategories()
        );
    }

}