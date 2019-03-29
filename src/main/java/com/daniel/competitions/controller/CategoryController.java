package com.daniel.competitions.controller;

import com.daniel.competitions.dto.CategoryDTO;
import com.daniel.competitions.entity.Category;
import com.daniel.competitions.mapper.CategoryMapper;
import com.daniel.competitions.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;
    private CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @PostMapping("/add")
    public CategoryDTO addCategory(@RequestBody Category category) {
        return categoryMapper.toDTO(categoryService.addCategory(category));
    }

    @GetMapping("/all")
    public List<CategoryDTO> findAll () {
        return categoryMapper.toDTOList(categoryService.findAll());
    }

}
