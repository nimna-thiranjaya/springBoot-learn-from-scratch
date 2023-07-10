package com.nimna.eLibrarysystem.service.impl;

import com.nimna.eLibrarysystem.dto.request.CategorySaveRequestDTO;
import com.nimna.eLibrarysystem.dto.response.CategoryResponseDTO;
import com.nimna.eLibrarysystem.entity.Category;
import com.nimna.eLibrarysystem.exception.NotFoundException;
import com.nimna.eLibrarysystem.repository.CategoryRepo;
import com.nimna.eLibrarysystem.service.CategoryService;
import com.nimna.eLibrarysystem.util.mapper.CategoryMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceIMPL implements CategoryService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public String saveCategory(CategorySaveRequestDTO categorySaveRequestDTO) {
        Category category = modelMapper.map(categorySaveRequestDTO, Category.class);
        category.setCategoryStatus(true);

        categoryRepo.save(category);

        return "Category Created!";
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryMapper.categoryEntityListToResponseList(categoryRepo.findAll());
    }

    @Override
    public String updateCategory(int categoryID, CategorySaveRequestDTO categorySaveRequestDTO) {
        if(categoryRepo.existsById(categoryID)){
            Category existCategory = categoryRepo.getReferenceById(categoryID);

            existCategory.setCategoryName(categorySaveRequestDTO.getCategoryName());
            existCategory.setCategoryDescription(categorySaveRequestDTO.getCategoryDescription());

            categoryRepo.save(existCategory);

            return "Category Updated!";
        }else{
            throw new NotFoundException("Category not found!");
        }
    }

    @Override
    public String deleteCategory(int categoryID) {
        if(categoryRepo.existsById(categoryID)){
            categoryRepo.deleteById(categoryID);
            return "Category Deleted!";
        }else{
            throw new NotFoundException("Category not found!");
        }
    }
}
