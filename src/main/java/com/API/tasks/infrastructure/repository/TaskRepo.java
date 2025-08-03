package com.API.tasks.infrastructure.repository;

import com.API.tasks.infrastructure.entitys.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<TaskEntity, Long> {
    public List<TaskEntity> findByDescriptionContainingIgnoreCase(String description);
}
