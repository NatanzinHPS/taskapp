package com.taskapp.dto;

import java.time.LocalDateTime;

import com.taskapp.model.Task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Task.Status status;
    private LocalDateTime createdAt;
}