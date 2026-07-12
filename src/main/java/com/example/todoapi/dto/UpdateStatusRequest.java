package com.example.todoapi.dto;

import com.example.todoapi.model.TaskStatus;
import jakarta.validation.constraints.NotNull;

public class UpdateStatusRequest {


    @NotNull(message = "Status wajib diisi")
    private TaskStatus status;


    public UpdateStatusRequest() {
    }


    public TaskStatus getStatus() {
        return status;
    }


    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}