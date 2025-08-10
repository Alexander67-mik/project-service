package com.TestBirds.project_service.controller;

import com.TestBirds.project_service.dto.CategoryCreate;
import com.TestBirds.project_service.dto.CategoryUpgrade;
import com.TestBirds.project_service.model.Category;
import com.TestBirds.project_service.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import jakarta.validation.Valid;

@RequestMapping("/categories")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    private Category catOr404(Integer id){
        Category foundCategory = categoryService.getOneCat(id);
        if(foundCategory == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return foundCategory;
    }
    @PostMapping()
    public ResponseEntity<Category> createAction(@Valid @RequestBody CategoryCreate categoryCreate) {
        Category newCategory = categoryService.cCreate(categoryCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getAction(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(catOr404(id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Category> updateAction(@PathVariable Integer id, @RequestBody CategoryUpgrade cdata){
        Category foundCategory = catOr404(id);
        Category updatedCategory = categoryService.upOneCat(cdata, foundCategory);
        return ResponseEntity.ok(updatedCategory);
    }
    @GetMapping()
    public ResponseEntity<List<Category>> findAllAction(@RequestParam(required = false) String name) {
        List<Category> categories = categoryService.findAllCat(name);
        return ResponseEntity.ok(categories);
    }

}
