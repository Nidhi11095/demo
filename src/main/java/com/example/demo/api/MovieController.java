package com.example.demo.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("api/v1/movie")

public class MovieController {
	
	private final MovieService movieService;
	
	@Autowired
	public MovieController(MovieService movieService) {
		
		this.movieService = movieService;
		//Queue<Integer> q = new LinkedList<>();
		
	}
  
    
	
	@PostMapping
	public void addMovie(@RequestBody Movie movie) {
		movieService.addMovie(movie);
		
	}
	
//	@RequestMapping("/")
//	@GetMapping
//	public String home() {
//		return "Welcome Nidhi";
//	}
	
//	@GetMapping
//	@RequestMapping("/getMovies")
//	public List<Movie> getMovies() {
//		System.out.println("get all movies");
//		return movieService.getAllMovies();
//	}
	
//	@GetMapping(path = "{id}")
//	public Movie getMovieById(@NonNull @PathVariable("id") UUID id) {
//		Optional<Movie> movie = movieService.getMovieById(id);
//		
//		if(!movie.isEmpty()) {
//			return movie.get();
//		} else {
//			return null;
//		}
//		
//	}
	
	@GetMapping("/getMovies")
	public List<Movie> getMovies() {
	    System.out.println("get all movies");
	    return movieService.getAllMovies();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable UUID id) {
		
		System.out.println("herre");
	    Optional<Movie> movie = movieService.getMovieById(id);
	    
	    if (movie.isPresent()) {
	        return ResponseEntity.status(HttpStatus.OK).body(movie.get()); // 200
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
	    }
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteMovieById(@NonNull @PathVariable("id") UUID id) {
		movieService.deletMovieById(id);
	}
	
//	@PutMapping(path = "{id}")
//	public void updateMovie(@PathVariable("id") UUID id, @RequestBody int newRating) {
//		
//		movieService.updateMovieRatingById(id, newRating);
//	}

}
