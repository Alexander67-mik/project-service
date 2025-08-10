package com.TestBirds.project_service.mapper;

import com.TestBirds.project_service.dto.CategoryCreate;
import com.TestBirds.project_service.dto.CategoryUpgrade;
import com.TestBirds.project_service.model.Category;

import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category catCreate (CategoryCreate categoryCreate);
    void  catUpdate(CategoryUpgrade categoryUpgrade, @MappingTarget Category category);

}
