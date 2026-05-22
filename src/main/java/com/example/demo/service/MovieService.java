package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MovieDao;
import com.example.demo.model.Movie;

@Service
public class MovieService {
	
	private final MovieDao movieDao;
	
	@Autowired
	public MovieService(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
	
	public int addMovie(Movie movie) {
		return movieDao.insertMovie(movie);
		
	}
	
	public List<Movie> getAllMovies() {
		return movieDao.getAllMovies();
	}
	
	public boolean deletMovieById(UUID id) {
		return movieDao.deleteMovieById(id);
		
	}
	
	public Optional<Movie> getMovieById(UUID id) {
		return movieDao.getMovieById(id);
	}
	
	public Movie getMovieByName(String name) {
		return movieDao.getMovieByName(name);
	}
	
	public void updateMovieRatingById(UUID id, int newRating) {
		movieDao.updateMovieRatingById(id, newRating);
	}

}
