package org.example.book;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private String genre;
    private double rating;
    private int publicationYear;
}
