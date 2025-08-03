package com.API.tasks.business.mapstruct;

import com.API.tasks.business.dtos.TaskRequestDTO;
import com.API.tasks.business.dtos.TaskResponseDTO;
import com.API.tasks.infrastructure.entitys.TaskEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-02T19:52:43-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.1 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskEntity toEntity(TaskRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setDescription( dto.description() );
        taskEntity.setStatus( dto.status() );

        return taskEntity;
    }

    @Override
    public TaskResponseDTO toResponse(TaskEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String description = null;
        String status = null;

        description = entity.getDescription();
        status = entity.getStatus();

        TaskResponseDTO taskResponseDTO = new TaskResponseDTO( description, status );

        return taskResponseDTO;
    }

    @Override
    public List<TaskResponseDTO> toResponseList(List<TaskEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TaskResponseDTO> list = new ArrayList<TaskResponseDTO>( entities.size() );
        for ( TaskEntity taskEntity : entities ) {
            list.add( toResponse( taskEntity ) );
        }

        return list;
    }
}
