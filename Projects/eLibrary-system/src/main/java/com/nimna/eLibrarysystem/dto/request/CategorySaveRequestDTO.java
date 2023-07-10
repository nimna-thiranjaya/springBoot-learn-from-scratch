package com.nimna.eLibrarysystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CategorySaveRequestDTO {

    @NotEmpty(message = "Category name required!")
    private String categoryName;

    private String categoryDescription;

}
