package com.nimna.eLibrarysystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CategoryResponseDTO {

    private int id;

    private String categoryName;

    private String categoryDescription;

    private Date createdAt;

    private Date updatedAt;
}
