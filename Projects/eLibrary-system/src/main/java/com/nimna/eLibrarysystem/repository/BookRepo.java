package com.nimna.eLibrarysystem.repository;

import com.nimna.eLibrarysystem.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BookRepo extends JpaRepository<Book,Integer> {
    Page<Book> findAllByBookStatus(boolean status, Pageable pageable);

}
