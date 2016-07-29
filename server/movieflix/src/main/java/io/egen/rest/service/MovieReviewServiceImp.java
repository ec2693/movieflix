package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.MovieReview;
import io.egen.rest.exception.ReviewAlreadyExistsException;
import io.egen.rest.exception.ReviewDoesNotExistsException;
import io.egen.rest.repository.MovieReviewRepository;

@Service
public class MovieReviewServiceImp implements MovieReviewService{
	
	@Autowired
	MovieReviewRepository repository;
	@Override
	public List<MovieReview> getAllReview() {
		return repository.getAllReview();
	}

	@Override
	public List<MovieReview> getAllReviewForMovie(String movieId) {
		return repository.getAllReviewForMovie(movieId);
	}

	@Override
	public List<MovieReview> getAllReviewByUser(String userId) {
		return repository.getAllReviewByUser(userId);
	}
	
	@Override
	public MovieReview getReviewByUserForMovie(String userId, String movieId) {
		return repository.getReviewByUserForMovie(userId,movieId);
	}


	@Override
	@Transactional
	public MovieReview createMovieReview(MovieReview movieReview) {
		MovieReview existing = repository.getReviewByUserForMovie(movieReview.getMovie().getId(),movieReview.getUser().getId());
		if(existing != null){
			throw new ReviewAlreadyExistsException("Review for movie   "+movieReview.getMovie().getTitle()+" by user"+movieReview.getUser().getUserName()+"  already exist");
		}
		return repository.createMovieReview(movieReview);
	}

	@Override
	@Transactional
	public MovieReview updateMovieReview(String userId,String movieId,MovieReview movieReview) {
		MovieReview existing = repository.getReviewByUserForMovie(userId,movieId);
		if(existing == null){
			throw new ReviewDoesNotExistsException("Review for movie   "+movieReview.getMovie().getTitle()+" by user"+movieReview.getUser().getUserName()+"  doesn't exist");
		}
		return repository.updateMovieReview(existing);
	}

	@Override
	@Transactional
	public void deleteMovieReview(String userId, String movieId) {
		MovieReview existing = repository.getReviewByUserForMovie(userId,movieId);
		if(existing == null){
			throw new ReviewDoesNotExistsException("Review for movie   "+movieId+" by user"+userId+"  doesn't exist");
		}
		repository.deleteMovieReview(existing);
	}
	

	@Override
	@Transactional
	public void deleteAllMovieReviewForUser(String userId) {
		List<MovieReview> existings = repository.getAllReviewByUser(userId);
		repository.deleteAllMovieReviewForUser(existings);
		
	}

	@Override
	@Transactional
	public void deleteAllMovieReviewForMovie(String movieId) {
		List<MovieReview> existings = repository.getAllReviewForMovie(movieId);
		repository.deleteAllMovieReviewForMovie(existings);

	}

	

}
