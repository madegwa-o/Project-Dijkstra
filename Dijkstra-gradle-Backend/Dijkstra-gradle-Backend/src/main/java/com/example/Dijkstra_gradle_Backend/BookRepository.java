package com.example.Dijkstra_gradle_Backend;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface BookRepository extends MongoRepository<Book, Integer> {
    Optional<Book> findFirstByAuthorId(Integer id);
}
