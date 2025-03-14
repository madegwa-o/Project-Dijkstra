package com.example.Dijkstra_gradle_Backend;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record Book(Integer id,
                   String name,
                   Integer pageCount,
                   Integer authorId,
                   Integer publishedYear,
                   String genre,
                   Double price,
                   String language,
                   String publisher,
                   String isbn) {


}
