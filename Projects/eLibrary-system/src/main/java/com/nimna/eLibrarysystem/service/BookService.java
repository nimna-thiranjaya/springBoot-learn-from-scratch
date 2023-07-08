package com.nimna.eLibrarysystem.service;

import com.nimna.eLibrarysystem.dto.BookDTO;
import com.nimna.eLibrarysystem.dto.paginated.PaginatedBookResponseDTO;
import com.nimna.eLibrarysystem.dto.request.BookSaveRequestDTO;

import java.util.List;

public interface BookService {
    public String saveBook(BookSaveRequestDTO bookSaveRequestDTO);

    public BookDTO getBookById(int bookId);

    public String editBookByID(int bookId, BookSaveRequestDTO bookSaveRequestDTO);

    public  String deleteBookByID(int bookId);

    public List<BookDTO> getAllBooks();

    public PaginatedBookResponseDTO getAllBooksWithPagination(int pageNumber, int pageSize);

    public PaginatedBookResponseDTO getAllBookFromStatusPaginated(boolean status, int pageNumber, int pageSize);
}
