package org.example.book;

import java.util.List;
import java.util.Set;

public class  Main {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();

        System.out.println("Books by George Orwell:");
        List<String> orwellBooks = library.filterBookTitles(book -> book.getAuthor().equals("George Orwell"));
        orwellBooks.forEach(System.out::println);

        double averageFictionRating = library.calculateAverageRating("Fiction");
        System.out.printf("\nAverage rating of Fiction books: %.1f%n", averageFictionRating);

        System.out.println("\nBooks sorted by publication year:");
        List<Book> sortedBooks = library.sortBooksByPublicationYear();
        sortedBooks.forEach(System.out::println);

        System.out.println("\nDistinct authors:");
        Set<String> distinctAuthors = library.getDistinctAuthors();
        distinctAuthors.forEach(System.out::println);

        String formattedDetails = library.formatBookDetails(book ->
                String.format("Title: %s, Author: %s, Genre: %s, Rating: %.1f, Year: %d",
                        book.getTitle(), book.getAuthor(), book.getGenre(), book.getRating(), book.getPublicationYear())
        );
        System.out.println("\nFormatted Book Details:\n" + formattedDetails);
    }
}