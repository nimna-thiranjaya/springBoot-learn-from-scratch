package com.nimna.eLibrarysystem.controller;

import com.nimna.eLibrarysystem.dto.request.CategorySaveRequestDTO;
import com.nimna.eLibrarysystem.service.CategoryService;
import com.nimna.eLibrarysystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping(path = "api/vi/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(path = "save")
    public ResponseEntity<StandardResponse> saveCategory(@RequestBody @Valid CategorySaveRequestDTO categorySaveRequestDTO) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", categoryService.saveCategory(categorySaveRequestDTO)),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "get-all-category")
    public ResponseEntity<StandardResponse> getAllCategory() {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", categoryService.getAllCategories()),
                HttpStatus.OK
        );
    }

    @PatchMapping(
            path = "edit-category/{id}"
    )
    public ResponseEntity<StandardResponse> editCategory(@PathVariable(value = "id") int categoryID, @RequestBody CategorySaveRequestDTO categorySaveRequestDTO) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", categoryService.updateCategory(categoryID, categorySaveRequestDTO)),
                HttpStatus.OK
        );
    }

    @DeleteMapping(
            path = "delete-category/{id}"
    )
    public ResponseEntity<StandardResponse> deleteCategory(@PathVariable(value = "id") int categoryID){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", categoryService.deleteCategory(categoryID)),
                HttpStatus.OK
        );
    }
}
