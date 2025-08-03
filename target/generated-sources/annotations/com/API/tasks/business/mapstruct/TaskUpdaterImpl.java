package com.API.tasks.business.mapstruct;

import com.API.tasks.business.dtos.TaskRequestDTO;
import com.API.tasks.infrastructure.entitys.TaskEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-02T19:52:43-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class TaskUpdaterImpl implements TaskUpdater {

    @Override
    public TaskEntity updateTask(TaskRequestDTO taskRequestDTO, TaskEntity taskEntity) {
        if ( taskRequestDTO == null ) {
            return taskEntity;
        }

        if ( taskRequestDTO.description() != null ) {
            taskEntity.setDescription( taskRequestDTO.description() );
        }
        if ( taskRequestDTO.status() != null ) {
            taskEntity.setStatus( taskRequestDTO.status() );
        }

        return taskEntity;
    }
}
