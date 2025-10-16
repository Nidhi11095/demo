package com.example.demo.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "movies")
public class Movie {
	
	@Id
	private UUID id;
	private final String name;
	private int rating;
	
	public Movie(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("rating") int rating) {
		this.id = id;
		this.name = name;
		this.rating = rating;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		
		this.rating = rating;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

}
