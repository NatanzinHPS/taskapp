package com.taskapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskapp.dto.TaskRequestDTO;
import com.taskapp.dto.TaskResponseDTO;
import com.taskapp.mapper.TaskMapper;
import com.taskapp.model.Task;
import com.taskapp.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    public TaskService(TaskRepository repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TaskResponseDTO createTask(TaskRequestDTO dto) {
        Task task = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(task));
    }

    public List<TaskResponseDTO> getAllTasks() {
        return mapper.toDTOList(repository.findAll());
    }

    public TaskResponseDTO getTaskById(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return mapper.toDTO(task);
    }

    public TaskResponseDTO updateTask(Long id, TaskRequestDTO dto) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        mapper.updateTaskFromDTO(dto, task);
        return mapper.toDTO(repository.save(task));
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
