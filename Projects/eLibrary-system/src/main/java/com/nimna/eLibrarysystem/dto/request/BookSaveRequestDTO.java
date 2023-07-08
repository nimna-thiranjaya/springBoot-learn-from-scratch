package com.nimna.eLibrarysystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookSaveRequestDTO {
    @NotEmpty(message = "Book name required!")
    private String bookName;

    @NotEmpty(message = "Book author required!")
    private String bookAuthor;

    private ArrayList bookCategory;

    private String bookDescription;

    @NotEmpty(message = "Book banner required!")
    private String bookBanner;

    @NotEmpty(message = "eBook required!")
    private String eBook;
}
