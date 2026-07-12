package com.example.todoapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoryRequest {

    @NotBlank(message = "Nama kategori wajib diisi")
    @Size(max = 50, message = "Nama kategori maksimal 50 karakter")
    private String name;


    public CategoryRequest() {
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}