package com.TestBirds.project_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    ThreadMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapCreate(UserCreate userCreate);

    // void mapUpdate(UserUpdate threadUpdate, @MappingTarget User user);
}