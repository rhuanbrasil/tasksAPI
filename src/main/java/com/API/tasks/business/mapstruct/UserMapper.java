package com.API.tasks.business.mapstruct;

import com.API.tasks.business.dtos.UserDTO;
import com.API.tasks.infrastructure.entitys.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    UserEntity userDTOtoEntity(UserDTO userDTO);




}
