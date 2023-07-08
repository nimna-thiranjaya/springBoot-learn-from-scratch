package com.nimna.eLibrarysystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BookDTO {

    private int bookId;

    private String bookName;

    private String bookAuthor;

    private ArrayList bookCategory;

    private String bookDescription;

    private String bookBanner;

    private String eBook;

    private boolean bookStatus;

    private Date createdAt;

    private Date updatedAt;
}
