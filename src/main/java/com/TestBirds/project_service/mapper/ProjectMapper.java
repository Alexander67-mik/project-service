package com.TestBirds.project_service.mapper;

import com.TestBirds.project_service.dto.ProjectCreate;
import com.TestBirds.project_service.dto.ProjectUpdate;
import com.TestBirds.project_service.model.Project;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    Project proCreate(ProjectCreate projectCreate);
    void  proUpdate(ProjectUpdate projectUpdate, @MappingTarget Project project);

}
