package com.API.tasks.business.mapstruct;

import com.API.tasks.business.dtos.TaskRequestDTO;
import com.API.tasks.business.dtos.TaskResponseDTO;
import com.API.tasks.infrastructure.entitys.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(target = "id", ignore = true)
    TaskEntity toEntity(TaskRequestDTO dto);

    TaskResponseDTO toResponse(TaskEntity entity);

    List<TaskResponseDTO> toResponseList(List<TaskEntity> entities);
}
