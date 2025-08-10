package com.TestBirds.project_service.service;

import com.TestBirds.project_service.dto.CategoryCreate;
import com.TestBirds.project_service.dto.CategoryUpgrade;
import com.TestBirds.project_service.mapper.CategoryMapper;
import com.TestBirds.project_service.model.Category;
import com.TestBirds.project_service.model.Project;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CategoryService {
    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
    public Category save(Category gen) {
        return gen;
    }
    public Category getOneCat(Integer id){
        if(id != 1){
            return null;
        }
        Category newCategory = new Category();
        newCategory.setId(id);
        newCategory.setName("Name");
        newCategory.setPriority(1);
        List<Project> projects = new ArrayList<>();
        projects.add(new Project());
        newCategory.setProjects(projects);
        return newCategory;
    }
    public Category upOneCat(CategoryUpgrade cdata, Category category){
        categoryMapper.catUpdate(cdata, category);
        save(category);
        return category;
    }
    public List<Category> findAllCat(String name){
        Category category1 = new Category();
        Category category2 = new Category();
        Category category3 = new Category();
        category1.setId(1);
        category1.setName("Name");
        category1.setPriority(1);
        category1.setProjects(List.of(new Project()));
        category2.setId(2);
        category2.setName("Name2");
        category2.setPriority(2);
        category2.setProjects(List.of(new Project()));
        category3.setId(3);
        category3.setName("Name3");
        category3.setPriority(3);
        category3.setProjects(List.of(new Project()));
        return Stream.of(category1, category2, category3).filter(p -> p.getName().equals(name)).toList();
    }
    public Category cCreate(CategoryCreate cr){
        Category category = categoryMapper.catCreate(cr);
        Project project = new Project();
        project.setId("project1");
        project.setTitle("Zaglavie");
        project.setDescription("opisanieto trqbva da bude mnogo dulgo inache ne go validira");
        project.setActive(true);
        category.setProjects(List.of(project));
        save(category);
        return category;
    }

}
