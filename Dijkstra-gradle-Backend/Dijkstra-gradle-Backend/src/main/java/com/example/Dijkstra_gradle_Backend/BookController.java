package com.example.Dijkstra_gradle_Backend;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @QueryMapping
    public List<Book> books() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Book bookById(@Argument Integer id) {
        return bookService.getBookById(id);
    }

    @QueryMapping
    public List<Book> cheapBooks() {
        return bookService.getCheapBooks();
    }

    @QueryMapping
    public Book exploreAuthorsBooks(@Argument String author) {
        return bookService.discoverAuthorsBook(author);
    }

    @SchemaMapping
    public Optional<Author> author(Book book) {
        return bookService.getAuthorById(book.authorId());
    }

}
