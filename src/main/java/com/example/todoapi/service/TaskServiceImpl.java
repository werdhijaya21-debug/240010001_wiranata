package com.example.todoapi.service;


import com.example.todoapi.model.Task;
import com.example.todoapi.model.TaskStatus;
import com.example.todoapi.repository.TaskRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import java.util.ArrayList;


@Service
public class TaskServiceImpl implements TaskService {


    private final TaskRepository taskRepository;


    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }



    @Override
    public Task createTask(Task task) {

        return taskRepository.save(task);

    }



    @Override
    public List<Task> getAllTasks() {

        return taskRepository.findByIsDeletedFalse();

    }



    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {

        return taskRepository.findByStatusAndIsDeletedFalse(status);

    }



    @Override
    public List<Task> getTasksByCategory(UUID categoryId) {

        return taskRepository.findByCategoryIdAndIsDeletedFalse(categoryId);

    }



    @Override
    public Task getTaskById(UUID id) {

        return taskRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Task tidak ditemukan")
                );

    }



    @Override
    public Task updateTask(UUID id, Task taskBaru) {


        Task taskLama = getTaskById(id);


        taskLama.setTitle(taskBaru.getTitle());

        taskLama.setDescription(taskBaru.getDescription());

        taskLama.setCategory(taskBaru.getCategory());

        taskLama.setStatus(taskBaru.getStatus());

        taskLama.setDueDate(taskBaru.getDueDate());


        taskLama.setUpdatedAt(LocalDateTime.now());


        return taskRepository.save(taskLama);

    }



    @Override
    public Task updateStatus(UUID id, TaskStatus status) {


        Task task = getTaskById(id);


        task.setStatus(status);

        task.setUpdatedAt(LocalDateTime.now());


        return taskRepository.save(task);

    }



    @Override
    public void deleteTask(UUID id) {


        Task task = getTaskById(id);


        task.setIsDeleted(true);


        taskRepository.save(task);

    }


@Override
public Object getTasksPagination(Integer page, Integer pageSize) {

    List<Task> tasks = taskRepository.findByIsDeletedFalse();


    int start = page * pageSize;

    int end = Math.min(
            start + pageSize,
            tasks.size()
    );


    return tasks.subList(start, end);

}

}