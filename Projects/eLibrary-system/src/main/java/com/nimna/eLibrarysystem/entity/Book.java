package com.nimna.eLibrarysystem.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Book {
    @Id
    @Column(name = "book_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    @Column(name = "book_name", length = 200, nullable = false)
    @NotEmpty(message = "Book name required!")
    private String bookName;

    @Column(name = "book_author", length = 200, nullable = false)
    private String bookAuthor;

    @Type(type = "json")
    @Column(name = "book_category", columnDefinition = "json")
    private ArrayList bookCategory;

    @Column(name = "book_description", length = 500)
    private String bookDescription;

    @Column(name = "book_banner", nullable = false)
    private String bookBanner;

    @Column(name = "e_book", nullable = false)
    private String eBook;

    @Column(name = "nook_status", columnDefinition = "TINYINT default 0")
    private boolean bookStatus;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
