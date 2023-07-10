package com.nimna.eLibrarysystem.service;

import com.nimna.eLibrarysystem.dto.request.CategorySaveRequestDTO;
import com.nimna.eLibrarysystem.dto.response.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    public String saveCategory(CategorySaveRequestDTO categorySaveRequestDTO);

    public List<CategoryResponseDTO> getAllCategories();

    public String updateCategory(int categoryID, CategorySaveRequestDTO categorySaveRequestDTO);

    public String deleteCategory(int categoryID);
}
