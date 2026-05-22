package com.example.demo.dao;

import com.example.demo.model.Movie;
import com.example.demo.respository.MongoMovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mongoDao")  // You can switch with @Qualifier in service
@Primary
public class MongoMovieDao implements MovieDao {

    @Autowired
    private MongoMovieRepository repository;

    @Override
    public int insertMovie(UUID id, Movie movie) {
        movie.setId(id);
        repository.save(movie);
        return 1;
    }

    @Override
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public boolean deleteMovieById(UUID id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void updateMovieRatingById(UUID id, int newRating) {
        Optional<Movie> optional = repository.findById(id);
        optional.ifPresent(movie -> {
            movie.setRating(newRating);
            repository.save(movie);
        });
    }

	@Override
	public Movie getMovieByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
