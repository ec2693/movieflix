package io.egen.rest.service;

import java.util.List;
import io.egen.rest.entity.Movie;

public interface MovieService {
	
	public List<Movie> findAll();
	
	public Movie findById(String movieId);
	
	public Movie findByTitle(String title);
	
	public List<Movie> findAllByType(String type);
	
	public List<Movie> findAllByYear(int year);
	
	public List<Movie> findAllByGenre(String genre);
	
	public List<Movie> findAllByTypeAndGenre(String type, String genreType);
	
	public List<Movie> sortAllByYear();
	
	public List<Movie> sortAllByTypeAndYear(String type);
	
	public Double getAverageRatingByUsers(String titleId);
	
	public Movie createMovie(Movie movie);
	
	public Movie updateMovie(String movieId,Movie movie);
	
	public void deleteMovie(String movieId);

	

	

	

	

	

}
