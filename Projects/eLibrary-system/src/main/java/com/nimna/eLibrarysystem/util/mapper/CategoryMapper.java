package com.nimna.eLibrarysystem.util.mapper;

import com.nimna.eLibrarysystem.dto.response.CategoryResponseDTO;
import com.nimna.eLibrarysystem.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    List<CategoryResponseDTO> categoryEntityListToResponseList(List<Category> categories);
}
