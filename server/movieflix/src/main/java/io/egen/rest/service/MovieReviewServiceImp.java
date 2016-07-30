package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Movie;
import io.egen.rest.entity.MovieReview;
import io.egen.rest.entity.User;
import io.egen.rest.exception.ReviewDoesNotExistsException;
import io.egen.rest.repository.MovieReviewRepository;

@Service
public class MovieReviewServiceImp implements MovieReviewService{
	
	@Autowired
	MovieReviewRepository repository;
	
	@Autowired
	MovieService mService;
	
	@Autowired
	UserService uService;
	
	@Override
	public List<MovieReview> getAllReview() {
		return repository.getAllReview();
	}

	@Override
	public List<MovieReview> getAllReviewForMovie(String movieId) {
		Movie movie = mService.findById(movieId);
		return repository.getAllReviewForMovie(movie);
	}

	@Override
	public List<MovieReview> getAllReviewByUser(String userId) {
		User user = uService.getUserByUserId(userId);
		return repository.getAllReviewByUser(user);
	}
	
	@Override
	public MovieReview getReviewByUserForMovie(String userId, String movieId) {
		Movie movie = mService.findById(movieId);
		User user = uService.getUserByUserId(userId);
		return repository.getReviewByUserForMovie(user,movie);
	}


	@Override
	@Transactional
	public MovieReview createMovieReview(MovieReview movieReview) {
		String movieId = movieReview.getMovie().getId();
		String userId = movieReview.getUser().getId();
		
//		MovieReview existing = repository.getReviewByUserForMovie(userId,movieId);
//		if(existing != null){
//			throw new ReviewAlreadyExistsException("Review for movie   "+movieReview.getMovie().getTitle()+" by user"+movieReview.getUser().getUserName()+"  already exist");
//		}
//	else
		Movie movie = mService.findById(movieId);
		User user = uService.getUserByUserId(userId);
		  movieReview.setMovie(movie);
		  movieReview.setUser(user);
		return repository.createMovieReview(movieReview);
	   //}
	}

	@Override
	@Transactional
	public MovieReview updateMovieReview(String movieReviewId,MovieReview movieReview) {
//		MovieReview existing = repository.getReviewByUserForMovie(userId,movieId);
//		if(existing == null){
//			throw new ReviewDoesNotExistsException("Review for movie   "+movieReview.getMovie().getTitle()+" by user"+movieReview.getUser().getUserName()+"  doesn't exist");
//		}
		MovieReview existing = repository.getMovieReviewById(movieReviewId);
		return repository.updateMovieReview(existing);
	}

	@Override
	@Transactional
	public void deleteMovieReview(String userId, String movieId) {
		Movie movie = mService.findById(movieId);
		User user = uService.getUserByUserId(userId);	
		MovieReview existing = repository.getReviewByUserForMovie(user,movie);
		if(existing == null){
			throw new ReviewDoesNotExistsException("Review for movie   "+movieId+" by user"+userId+"  doesn't exist");
		}
		repository.deleteMovieReview(existing);
	}
	

	@Override
	@Transactional
	public void deleteAllMovieReviewForUser(String userId) {
		User user = uService.getUserByUserId(userId);	
		List<MovieReview> existings = repository.getAllReviewByUser(user);
		repository.deleteAllMovieReviewForUser(existings);
		
	}

	@Override
	@Transactional
	public void deleteAllMovieReviewForMovie(String movieId) {
		Movie movie = mService.findById(movieId);
		List<MovieReview> existings = repository.getAllReviewForMovie(movie);
		repository.deleteAllMovieReviewForMovie(existings);

	}

	

}
