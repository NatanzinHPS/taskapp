package com.taskapp.dto;

import com.taskapp.model.Task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskRequestDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(max = 100)
    private String title;

    @Size(max = 500)
    private String description;

    private Task.Status status = Task.Status.TO_DO;
}