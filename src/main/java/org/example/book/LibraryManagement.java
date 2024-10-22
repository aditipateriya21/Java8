package org.example.book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LibraryManagement {
    private List<Book> books;

    public LibraryManagement() {
        books = new ArrayList<>();
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 4.2, 1925));
        books.add(new Book("1984", "George Orwell", "Dystopian", 4.4, 1949));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 4.3, 1960));
        books.add(new Book("Brave New World", "Aldous Huxley", "Dystopian", 4.1, 1932));
        books.add(new Book("Moby Dick", "Herman Melville", "Fiction", 3.5, 1851));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 3.8, 1951));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 4.7, 1937));
    }

    public List<String> filterBookTitles(Predicate<Book> condition) {
        return books.stream()
                .filter(condition)
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    public double calculateAverageRating(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .mapToDouble(Book::getRating)
                .average()
                .orElse(0.0); // Return 0.0 if there are no books in that genre
    }

    public List<Book> sortBooksByPublicationYear() {
        return books.stream()
                .sorted(Comparator.comparingInt(Book::getPublicationYear))
                .collect(Collectors.toList());
    }

    public Set<String> getDistinctAuthors() {
        return books.stream()
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toSet());
    }

    public String formatBookDetails(Function<Book, String> formatter) {
        return books.stream()
                .map(formatter)
                .collect(Collectors.joining("\n"));
    }
}
