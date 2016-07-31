package io.egen.rest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.rest.entity.Movie;
import io.egen.rest.service.MovieService;

@RestController
@RequestMapping(path = "movies")
public class MovieController {
	
	@Autowired
	MovieService service;
	
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "findById/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findById(@PathVariable("id") String movieId){
		return service.findById(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "findByTitle/{name}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findByTitle(@PathVariable("name") String title){
		return service.findByTitle(title);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "findAllByType/{type}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAllByType(@PathVariable("type") String type){
		return service.findAllByType(type);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "findAllByYear/{year}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAllByYear( @PathVariable("year") int year){
		return service.findAllByYear(year);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "findAllByGenre/{genre}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAllByGenre( @PathVariable("genre") String genre){
		return service.findAllByGenre(genre);
	}
	

	@RequestMapping(method = RequestMethod.GET, path = "findAllByTypeAndGenre/{type}/{genreType}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAllByTypeAndGenre(@PathVariable("type") String type,@PathVariable("genreType") String genreType){
		return service.findAllByTypeAndGenre(type,genreType);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "sortAllByYear",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortAllByYear(){
		return service.sortAllByYear();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "getAverageRatingForMovie/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Double getAverageRatingByUsers(@PathVariable("movieId") String movieId){
		return service.getAverageRatingByUsers(movieId);
	}
	
	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie createMovie(@RequestBody Movie movie){
		return service.createMovie(movie);
	}
	
	@RequestMapping(method = RequestMethod.PUT,path = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie updateMovie(@PathVariable("id") String movieId, @RequestBody Movie movie){
		return service.updateMovie(movieId, movie);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void deleteMovie(@PathVariable("id") String movieId){
		service.deleteMovie(movieId);
		
	}

}
