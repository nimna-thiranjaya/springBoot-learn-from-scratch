package com.nimna.eLibrarysystem.repository;

import com.nimna.eLibrarysystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
