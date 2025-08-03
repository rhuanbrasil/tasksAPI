package com.API.tasks.infrastructure.repository;

import com.API.tasks.infrastructure.entitys.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<TaskEntity, Long> {
    public TaskEntity findByDescriptionContainingIgnoreCase(String description);
}
