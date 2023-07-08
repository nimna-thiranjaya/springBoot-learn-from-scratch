package com.nimna.eLibrarysystem.controller;

import com.nimna.eLibrarysystem.dto.BookDTO;
import com.nimna.eLibrarysystem.dto.request.BookSaveRequestDTO;
import com.nimna.eLibrarysystem.service.BookService;
import com.nimna.eLibrarysystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;


@RestController
@RequestMapping(path = "api/v1/book")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(
            path = "/save"
    )
    public ResponseEntity<StandardResponse> saveBook(@RequestBody @Valid BookSaveRequestDTO bookSaveRequestDTO) {
        System.out.println(bookSaveRequestDTO);
        String message = bookService.saveBook(bookSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            path = "/get-specific-book/{id}"
    )
    public ResponseEntity<StandardResponse> getSpecificBook(@PathVariable(value = "id") int bookId) {
        BookDTO bookDTO = bookService.getBookById(bookId);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Succes", bookDTO),
                HttpStatus.OK
        );
    }

    @PatchMapping(
            path = "/edit-book/{id}"
    )
    public ResponseEntity<StandardResponse> editBookByid(@PathVariable(value = "id") int bookId, @RequestBody BookSaveRequestDTO bookSaveRequestDTO) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", bookService.editBookByID(bookId, bookSaveRequestDTO)),
                HttpStatus.OK
        );
    }

    @DeleteMapping(
            path = "delete-book/{id}"
    )
    private ResponseEntity<StandardResponse> deeleteBookBiID(@PathVariable(value = "id") int bookId) {

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", bookService.deleteBookByID(bookId)),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "get-all-books"
    )
    public ResponseEntity<StandardResponse> getAllBooks() {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", bookService.getAllBooks()),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "all-books-paginated",
            params = {"page-number", "page-size"}
    )
    public ResponseEntity<StandardResponse> getAllBooksWithPagination(
            @RequestParam(value = "page-number") int pageNumber,
            @RequestParam(value = "page-size") int pageSize
    ) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", bookService.getAllBooksWithPagination(pageNumber, pageSize)),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "active-books-paginated",
            params = {"status", "page-number", "page-size"}
    )
    public ResponseEntity<StandardResponse> getAllBooksFromStatusPaginated(
            @RequestParam(value = "status") boolean status,
            @RequestParam(value = "page-number") int pageNumber,
            @RequestParam(value = "page-size") int pageSize) {

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", bookService.getAllBookFromStatusPaginated(status, pageNumber, pageSize)),
                HttpStatus.OK
        );
    }
}
