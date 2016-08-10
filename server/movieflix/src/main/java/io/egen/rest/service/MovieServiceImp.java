package io.egen.rest.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.egen.rest.entity.Cast;
import io.egen.rest.entity.Genre;
import io.egen.rest.entity.Imdb;
import io.egen.rest.entity.Movie;
import io.egen.rest.exception.MovieAlreadyExistsException;
import io.egen.rest.exception.MovieDoesNotExistsException;
import io.egen.rest.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {
	
	@Autowired
	MovieRepository repository;
	
	@Autowired
	CastService cService;
	
	@Autowired
	ImdbService iService;
	
	@Autowired
	GenreService gService;
	
	@Autowired 
	MovieReviewService  mRService;

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
	public List<Movie> findAllByGenre(String genre) {
		return repository.findAllByGenre(genre);
	}
	
	@Override
	public List<Movie> findAllByTypeAndGenre(String type, String genreType) {
		return repository.findAllByTypeAndGenre(type,genreType);
	}


	@Override
	public List<Movie> sortAllByYear() {
		return repository.sortAllByYear();
	}
	
	@Override
	public List<Movie> sortAllByTypeAndYear(String type) {
		return repository.sortAllByTypeAndYear(type);
	}
	
	@Override
	public List<Movie> sortAllByTypeAndImdbRatings(String type) {
		return repository.sortAllByTypeAndImdbRatings(type);
	}
	
	@Override
	public List<Movie> sortAllByTypeAndImdbVotes(String type) {
		return repository.sortAllByTypeAndImdbVotes(type);
	}
	
	@Override
	public String getImdbLink(String titleName) {
	    return repository.getImdbLink(titleName);
	}

	@Override
	public Double getAverageRatingByUsers(String titleName) {
	  Movie movie =	repository.findByTitle(titleName);
	   return mRService.getAverageRating(movie);
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
		 Imdb imdb = movie.getImdb();
		    iService.createImdb(imdb);
		 List<Genre> genre = movie.getGenre();
		    gService .createGenre(genre); 
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
		 Imdb imdb = movie.getImdb();
		   iService.updateImdb(imdb);
		List<Genre> genre = movie.getGenre();
		  gService.updateGenre(genre);
		return repository.updateMovie(movie);
	}

	@Override
	@Transactional
	public void deleteMovie(String movieId) {
		Movie existing = repository.findById(movieId);
		 if(existing == null){
			 throw new MovieDoesNotExistsException("Movie with id  "+movieId+ "  doesn't exists");
		 }
		 List<Cast> cast = existing.getCast();
		     cService.deleteCast(cast);
		 Imdb imdb = existing.getImdb();
		    iService.deleteImdb(imdb);
		 List<Genre> genre = existing.getGenre();
			gService.deleteGenre(genre);
		  repository.deleteMovie(existing);
		
	}

	
}
