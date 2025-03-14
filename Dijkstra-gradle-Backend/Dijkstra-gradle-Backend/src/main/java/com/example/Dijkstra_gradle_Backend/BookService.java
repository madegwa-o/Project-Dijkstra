package com.example.Dijkstra_gradle_Backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepo authorRepo;


    public Book getBookById(Integer id) {
        return bookRepository.findAll().stream()
                .filter(book -> book.id().equals(id))
                .findFirst().orElse(null);

    }

    public List<Book> getShortBooks() {
        return bookRepository.findAll().stream()
                .filter(book -> book.pageCount() > 100)
                .collect(Collectors.toList());
    }

    public List<Book> getCheapBooks() {
        return bookRepository.findAll().stream()
                .filter(book -> book.price() < 20)
                .toList();
    }

    public Optional<Author> getAuthorById(Integer id) {
        return authorRepo.findById(id);
    }

    public Book discoverAuthorsBook(String author) {
        return authorRepo
                .findByUsername(author)
                .stream()
                .findFirst()
                .flatMap(writer -> bookRepository.findFirstByAuthorId(writer.id()))
                .orElse(null);

    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
