package com.example.todoapi.repository;

import com.example.todoapi.model.Task;
import com.example.todoapi.model.TaskStatus;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface TaskRepository extends JpaRepository<Task, UUID> {


    List<Task> findByIsDeletedFalse();


    List<Task> findByStatusAndIsDeletedFalse(TaskStatus status);


    List<Task> findByCategoryIdAndIsDeletedFalse(UUID categoryId);


}