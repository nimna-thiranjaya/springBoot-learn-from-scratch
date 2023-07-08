package com.nimna.eLibrarysystem.service.impl;

import com.nimna.eLibrarysystem.dto.BookDTO;
import com.nimna.eLibrarysystem.dto.paginated.PaginatedBookResponseDTO;
import com.nimna.eLibrarysystem.dto.request.BookSaveRequestDTO;
import com.nimna.eLibrarysystem.entity.Book;
import com.nimna.eLibrarysystem.exception.NotFoundException;
import com.nimna.eLibrarysystem.repository.BookRepo;
import com.nimna.eLibrarysystem.service.BookService;
import com.nimna.eLibrarysystem.util.mapper.BookMapper;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceIMPL implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookMapper bookMapper;
    @Override
    public String saveBook(BookSaveRequestDTO bookSaveRequestDTO) {
        Book newBook = modelMapper.map(bookSaveRequestDTO, Book.class);
        newBook.setBookStatus(true);

        bookRepo.save(newBook);

        return "Book Save Successful!";
    }

    @Override
    public BookDTO getBookById(int bookId) {
        if(bookRepo.existsById(bookId)){
            Book specificBook = bookRepo.getReferenceById(bookId);

            return modelMapper.map(specificBook, BookDTO.class);

        }else {
            throw new NotFoundException("Book not found!");
        }
    }

    @Override
    public String editBookByID(int bookId, BookSaveRequestDTO bookSaveRequestDTO) {
        if(bookRepo.existsById(bookId)){
            Book existBook = bookRepo.getReferenceById(bookId);

            return "Update Successful";
        }else{
            throw new NotFoundException("Book not found!");
        }
    }

    @Override
    public String deleteBookByID(int bookId) {
        if(bookRepo.existsById(bookId)){
            bookRepo.deleteById(bookId);

            return "Book deleted!";
        }else{
            throw new NotFoundException("Book not found!");
        }
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> allBooks = bookRepo.findAll();

        if(allBooks.size() > 0){
            return bookMapper.bookEntityListToBookDTO(allBooks);
        }else {
            throw new NotFoundException("Books not found");
        }
    }

    @Override
    public PaginatedBookResponseDTO getAllBooksWithPagination(int pageNumber, int pageSize) {
        Page<Book> books = bookRepo.findAll(PageRequest.of(pageNumber,pageSize));

        if(books.getTotalElements() > 0) {
            PaginatedBookResponseDTO paginatedBookResponseDTO = new PaginatedBookResponseDTO(
                    bookMapper.pageBookToListOfBookDTO(books),
                    books.getTotalElements(),
                    books.getTotalPages()
            );

            return paginatedBookResponseDTO;

        }else {
            throw new NotFoundException("Books not found");
        }
    }

    @Override
    public PaginatedBookResponseDTO getAllBookFromStatusPaginated(boolean status, int pageNumber, int pageSize) {
        Page<Book> books = bookRepo.findAllByBookStatus(status, PageRequest.of(pageNumber, pageSize));

        if(books.getTotalElements() > 0){
            PaginatedBookResponseDTO paginatedBookResponseDTO = new PaginatedBookResponseDTO(
                    bookMapper.pageBookToListOfBookDTO(books),
                    books.getTotalElements(),
                    books.getTotalPages()
            );

            return paginatedBookResponseDTO;
        }else {
            throw new NotFoundException("Books not found");
        }
    }

}
