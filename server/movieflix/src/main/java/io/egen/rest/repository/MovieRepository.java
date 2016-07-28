package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Movie;

public interface MovieRepository {
	
    public List<Movie> findAll();
    
    public Movie findById(String id);
	
	public Movie findByTitle(String title);
	
	public List<Movie> findAllByType(String type);
	
	public List<Movie> findAllByYear(int year);
	
	public List<Movie> sortAllByYear();
	
	public Movie createMovie(Movie movie);
	
	public Movie updateMovie(Movie movie);
	
	public void deleteMovie(Movie movie);

	

}
