package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Movie;

@Repository("fakeDao")
public class FakeMovieDataAccessService implements MovieDao{
	
	private static List<Movie> DB = new ArrayList<>();

	@Override
	public int insertMovie(UUID id, Movie movie) {
		DB.add(new Movie(id, movie.getName(), movie.getRating()));
		return 1;
	}


	public List<Movie> getAllMovies() {
		return DB;
	}


	@Override
	public Optional<Movie> getMovieById(UUID id) {
		
		 return DB.stream().filter((Movie m) -> {
			return m.getId().equals(id);
		}).findFirst();
	}


	@Override
	public boolean deleteMovieById(UUID id) {
		DB.remove(getMovieById(id).get());
		return true;
		
		
	}


	@Override
	public void updateMovieRatingById(UUID id, int newRating) {
		
		Movie movie = getMovieById(id).get();
		
		if(movie != null) {
			movie.setRating(newRating);
		}
		
		
	}


	
	public Movie getMovieByName(String name) {
		
		
		
		for(Movie m : DB) {
			if(m.getName().equals(name)) {
				return m;
			}
		}
		
		return null;
	}
	
	
	

}
