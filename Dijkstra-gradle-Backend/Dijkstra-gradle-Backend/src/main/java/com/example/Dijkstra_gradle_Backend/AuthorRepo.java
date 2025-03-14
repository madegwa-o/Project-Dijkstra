package com.example.Dijkstra_gradle_Backend;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepo extends MongoRepository<Author, Integer> {
   List<Author> findByUsername(String author);
}
