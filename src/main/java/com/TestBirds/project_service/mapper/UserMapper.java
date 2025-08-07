package com.TestBirds.project_service.mapper;

import com.TestBirds.project_service.dto.UserCreate;
import com.TestBirds.project_service.dto.UserUpdate;
import com.TestBirds.project_service.model.User;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapCreate(UserCreate userCreate);

    void mapUpdate(UserUpdate userUpdate, @MappingTarget User user);
}