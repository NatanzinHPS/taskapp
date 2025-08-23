package com.taskapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskapp.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}