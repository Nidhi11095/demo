package com.example.demo.respository;

import com.example.demo.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MongoMovieRepository extends MongoRepository<Movie, UUID> {
    // You can add custom queries here if needed
}
