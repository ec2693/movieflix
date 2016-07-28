package io.egen.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Cast;
import io.egen.rest.entity.Movie;
import io.egen.rest.exception.MovieAlreadyExistsException;
import io.egen.rest.exception.MovieDoesNotExistsException;
import io.egen.rest.repository.CastRepository;
import io.egen.rest.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {
	
	@Autowired
	MovieRepository repository;
	
	@Autowired
	CastService cService;

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Movie findById(String movieId) {
		Movie existing = repository.findById(movieId);
		if(existing == null){
			throw new MovieDoesNotExistsException("Movie with id  "+movieId+ "  doesn't exixts");
		}
		return existing;
	}

	@Override
	public Movie findByTitle(String title) {
		Movie existing = repository.findByTitle(title);
			if(existing == null){
				throw new MovieDoesNotExistsException("Movie with title  "+title+ "  doesn't exixts");
			}
		return existing;
	}

	@Override
	public List<Movie> findAllByType(String type) {
		return repository.findAllByType(type);
	}

	@Override
	public List<Movie> findAllByYear(int year) {
		return repository.findAllByYear(year);
	}

	@Override
	public List<Movie> sortAllByYear() {
		return repository.sortAllByYear();
	}

	@Override
	@Transactional
	public Movie createMovie(Movie movie) {
		Movie existing = repository.findByTitle(movie.getTitle());
		if(existing != null){
			throw new MovieAlreadyExistsException("Movie Already Exists");
		}
		 List<Cast> cast = movie.getCast();
			 cService.createCast(cast);
		return repository.createMovie(movie);
	}

	@Override
	@Transactional
	public Movie updateMovie(String movieId, Movie movie) {
		Movie existing = repository.findById(movieId);
		 if(existing == null){
			 throw new MovieDoesNotExistsException("Movie with id  "+movieId+ "  doesn't exists");
		 }
		 List<Cast> cast = movie.getCast();
		 cService.updateCast(cast);
		return repository.updateMovie(movie);
	}

	@Override
	@Transactional
	public void deleteMovie(String movieId) {
		Movie existing = repository.findById(movieId);
		 if(existing == null){
			 throw new MovieDoesNotExistsException("Movie with id  "+movieId+ "  doesn't exists");
		 }
		repository.deleteMovie(existing);
		
	}

}
