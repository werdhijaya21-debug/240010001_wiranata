package com.example.todoapi.dto;

import com.example.todoapi.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaskRequest {


    @NotBlank(message = "Title wajib diisi")
    @Size(max = 100, message = "Title maksimal 100 karakter")
    private String title;


    private String description;


    @NotNull(message = "Category wajib dipilih")
    private UUID categoryId;


    private TaskStatus status;


    private LocalDateTime dueDate;



    public TaskRequest() {
    }



    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public UUID getCategoryId() {
        return categoryId;
    }


    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }


    public TaskStatus getStatus() {
        return status;
    }


    public void setStatus(TaskStatus status) {
        this.status = status;
    }


    public LocalDateTime getDueDate() {
        return dueDate;
    }


    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}