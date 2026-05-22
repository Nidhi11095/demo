package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Movie;

public interface MovieDao {
	
	public int insertMovie(UUID id, Movie movie);
	
	public List<Movie> getAllMovies();
	
	default int insertMovie(Movie movie) {
		
		UUID id = UUID.randomUUID();
		
		return insertMovie(id, movie);
		
	}
	
	public Optional<Movie> getMovieById(UUID id);
	
	public boolean deleteMovieById(UUID id);
	
	public void updateMovieRatingById(UUID id, int newRating);
	
	public Movie getMovieByName(String name);

}
