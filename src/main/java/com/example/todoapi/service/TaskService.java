package com.example.todoapi.service;

import com.example.todoapi.model.Task;
import com.example.todoapi.model.TaskStatus;

import java.util.List;
import java.util.UUID;


public interface TaskService {


    Task createTask(Task task);


    List<Task> getAllTasks();


    List<Task> getTasksByStatus(TaskStatus status);


    List<Task> getTasksByCategory(UUID categoryId);


    Task getTaskById(UUID id);


    Task updateTask(UUID id, Task task);


    Task updateStatus(UUID id, TaskStatus status);


    void deleteTask(UUID id);

Object getTasksPagination(Integer page, Integer pageSize);
}