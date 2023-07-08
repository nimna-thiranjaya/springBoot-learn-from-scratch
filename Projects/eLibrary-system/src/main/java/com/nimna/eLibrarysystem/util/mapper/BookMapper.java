package com.nimna.eLibrarysystem.util.mapper;

import com.nimna.eLibrarysystem.dto.BookDTO;
import com.nimna.eLibrarysystem.dto.request.BookSaveRequestDTO;
import com.nimna.eLibrarysystem.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE ,componentModel = "spring")
public interface BookMapper {
    List<BookDTO> pageBookToListOfBookDTO (Page<Book> page);

    List<BookDTO> bookEntityListToBookDTO (List<Book> books);
}