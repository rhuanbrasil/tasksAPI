package com.API.tasks.business;

import com.API.tasks.business.dtos.TaskRequestDTO;
import com.API.tasks.business.dtos.TaskResponseDTO;
import com.API.tasks.business.mapstruct.TaskMapper;
import com.API.tasks.business.mapstruct.TaskUpdater;
import com.API.tasks.infrastructure.entitys.TaskEntity;
import com.API.tasks.infrastructure.repository.TaskRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepo repo;
    private final TaskMapper mapper;
    private final TaskUpdater updater;

    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        TaskEntity taskEntity = mapper.toEntity(taskRequestDTO);
        taskEntity.setCreatedAt(OffsetDateTime.now());
        return mapper.toResponse(repo.save(taskEntity));
    }
    public void updateTask(TaskRequestDTO taskRequestDTO, long id) {
        TaskEntity taskEntity = repo.findById(id).orElseThrow();
        updater.updateTask(taskRequestDTO, taskEntity);
    }
    public List<TaskResponseDTO> getTasks() {
        return mapper.toResponseList(repo.findAll());
    }
    public List<TaskResponseDTO> getTaskByDescription(String description) {
        return mapper.toResponseList(repo.findByDescriptionContainingIgnoreCase(description));
    }
    public void setToComplete(long id) {
        TaskEntity taskEntity = repo.findById(id).orElseThrow();
        taskEntity.setStatus("complete");
        repo.save(taskEntity);
    }
}
