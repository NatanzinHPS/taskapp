package com.taskapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskapp.dto.TaskRequestDTO;
import com.taskapp.dto.TaskResponseDTO;
import com.taskapp.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Tasks", description = "Gerenciamento de tarefas")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @Operation(summary = "Criar uma nova tarefa")
    @PostMapping
    public TaskResponseDTO createTask(@Valid @RequestBody TaskRequestDTO dto) {
        return service.createTask(dto);
    }

    @Operation(summary = "Listar todas as tarefas")
    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {
        return service.getAllTasks();
    }

    @Operation(summary = "Obter tarefa por ID")
    @GetMapping("/{id}")
    public TaskResponseDTO getTask(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @Operation(summary = "Atualizar uma tarefa")
    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(@PathVariable Long id, @Valid @RequestBody TaskRequestDTO dto) {
        return service.updateTask(id, dto);
    }

    @Operation(summary = "Deletar uma tarefa")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
