package com.example.todoapi.controller;


import com.example.todoapi.dto.TaskRequest;
import com.example.todoapi.dto.UpdateStatusRequest;
import com.example.todoapi.model.Category;
import com.example.todoapi.model.Task;
import com.example.todoapi.model.TaskStatus;
import com.example.todoapi.repository.CategoryRepository;
import com.example.todoapi.service.TaskService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {



    private final TaskService taskService;

    private final CategoryRepository categoryRepository;



    public TaskController(
            TaskService taskService,
            CategoryRepository categoryRepository
    ) {

        this.taskService = taskService;
        this.categoryRepository = categoryRepository;

    }




    // POST /api/tasks
    @PostMapping
    public ResponseEntity<Task> createTask(
            @Valid @RequestBody TaskRequest request
    ) {


        Category category = categoryRepository
                .findById(request.getCategoryId())
                .orElseThrow(
                        () -> new RuntimeException(
                                "Category tidak ditemukan"
                        )
                );


        Task task = new Task();


        task.setTitle(request.getTitle());

        task.setDescription(request.getDescription());

        task.setCategory(category);

        task.setStatus(request.getStatus());

        task.setDueDate(request.getDueDate());



        return new ResponseEntity<>(
                taskService.createTask(task),
                HttpStatus.CREATED
        );

    }




@GetMapping
public Object getTasks(
        @RequestParam(required = false) TaskStatus status,
        @RequestParam(required = false) UUID categoryId,
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer pageSize
) {


    if(page != null && pageSize != null){

        return taskService.getTasksPagination(page, pageSize);

    }


    if(status != null){

        return taskService.getTasksByStatus(status);

    }


    if(categoryId != null){

        return taskService.getTasksByCategory(categoryId);

    }


    return taskService.getAllTasks();

}


// GET /api/tasks/{id}
@GetMapping("/{id}")
public ResponseEntity<Task> getTaskById(
        @PathVariable UUID id
){

    return ResponseEntity.ok(
            taskService.getTaskById(id)
    );

}


    // PUT /api/tasks/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(
            @PathVariable UUID id,
            @RequestBody TaskRequest request
    ){


        Category category = categoryRepository
                .findById(request.getCategoryId())
                .orElseThrow(
                        () -> new RuntimeException(
                                "Category tidak ditemukan"
                        )
                );


        Task task = new Task();


        task.setTitle(request.getTitle());

        task.setDescription(request.getDescription());

        task.setCategory(category);

        task.setStatus(request.getStatus());

        task.setDueDate(request.getDueDate());



        return ResponseEntity.ok(
                taskService.updateTask(id, task)
        );

    }





    // PATCH /api/tasks/{id}/status
    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateStatusRequest request
    ){

        return ResponseEntity.ok(
                taskService.updateStatus(
                        id,
                        request.getStatus()
                )
        );

    }





    // DELETE /api/tasks/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(
            @PathVariable UUID id
    ){

        taskService.deleteTask(id);


        return ResponseEntity.ok(
                "Task berhasil dihapus"
        );

    }


}