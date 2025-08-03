package com.API.tasks.business.mapstruct;

import com.API.tasks.business.dtos.TaskRequestDTO;
import com.API.tasks.infrastructure.entitys.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskUpdater {
    TaskEntity updateTask(TaskRequestDTO taskRequestDTO, @MappingTarget TaskEntity taskEntity);
}
