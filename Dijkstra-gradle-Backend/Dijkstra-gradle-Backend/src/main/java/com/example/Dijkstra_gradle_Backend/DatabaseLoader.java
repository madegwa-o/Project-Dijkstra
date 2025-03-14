package com.example.Dijkstra_gradle_Backend;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseLoader {

    private final BookRepository bookRepository;
    private final AuthorRepo authorRepo;

    @Bean
    public CommandLineRunner init() {
        return args -> {
            List<Author> authors = Arrays.asList(
                    new Author(1, "William Shakespeare"),
                    new Author(2, "Jane Austen"),
                    new Author(3, "Charles Dickens"),
                    new Author(4, "Mark Twain"),
                    new Author(5, "Leo Tolstoy"),
                    new Author(6, "George Orwell"),
                    new Author(7, "J.K. Rowling"),
                    new Author(8, "Ernest Hemingway")
            );

            authorRepo.saveAll(authors);

            List<Book> books = Arrays.asList(
                    new Book(1, "Hamlet", 342, 1, 1601, "Drama", 15.00, "English", "First Folio Press", "1234567890123"),
                    new Book(2, "Romeo and Juliet", 298, 1, 1597, "Drama", 12.99, "English", "First Folio Press", "2345678901234"),
                    new Book(3, "Pride and Prejudice", 279, 2, 1813, "Romance", 9.99, "English", "T. Egerton", "5678910111214"),
                    new Book(4, "Emma", 474, 2, 1815, "Romance", 11.50, "English", "John Murray", "3456789101115"),
                    new Book(5, "A Tale of Two Cities", 489, 3, 1859, "Historical Fiction", 14.99, "English", "Chapman & Hall", "6789012345678"),
                    new Book(6, "Great Expectations", 505, 3, 1861, "Fiction", 16.99, "English", "Chapman & Hall", "8901234567890"),
                    new Book(7, "The Adventures of Tom Sawyer", 274, 4, 1876, "Adventure", 10.50, "English", "American Publishing Co.", "9012345678901"),
                    new Book(8, "Adventures of Huckleberry Finn", 366, 4, 1884, "Adventure", 12.50, "English", "Charles L. Webster and Company", "0123456789012"),
                    new Book(9, "War and Peace", 1225, 5, 1869, "Historical", 25.00, "Russian", "The Russian Messenger", "6789101112134"),
                    new Book(10, "Anna Karenina", 864, 5, 1878, "Romance", 22.50, "Russian", "The Russian Messenger", "5678910111415"),
                    new Book(11, "1984", 328, 6, 1949, "Dystopian", 13.99, "English", "Secker & Warburg", "4567891011123"),
                    new Book(12, "Animal Farm", 112, 6, 1945, "Political Satire", 9.50, "English", "Secker & Warburg", "3456789101125"),
                    new Book(13, "Harry Potter and the Philosopher's Stone", 223, 7, 1997, "Fantasy", 25.00, "English", "Bloomsbury", "6789012345612"),
                    new Book(14, "Harry Potter and the Chamber of Secrets", 251, 7, 1998, "Fantasy", 27.50, "English", "Bloomsbury", "7891011121315"),
                    new Book(15, "The Old Man and the Sea", 127, 8, 1952, "Fiction", 12.00, "English", "Charles Scribner's Sons", "5678910111122"),
                    new Book(16, "A Farewell to Arms", 332, 8, 1929, "War Fiction", 15.50, "English", "Charles Scribner's Sons", "6789101111133")
            );

            bookRepository.saveAll(books);
        };
    }
}
