package com.taskapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.taskapp.dto.TaskRequestDTO;
import com.taskapp.dto.TaskResponseDTO;
import com.taskapp.model.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Task toEntity(TaskRequestDTO dto);

    TaskResponseDTO toDTO(Task task);

    List<TaskResponseDTO> toDTOList(List<Task> tasks);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateTaskFromDTO(TaskRequestDTO dto, @MappingTarget Task entity);
}