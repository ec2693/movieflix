package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.MovieReview;

public interface MovieReviewRepository {
	
	public List<MovieReview> getAllReview();

	public List<MovieReview> getAllReviewForMovie(String movieId);

	public List<MovieReview> getAllReviewByUser(String userId);

	public MovieReview getReviewByUserForMovie(String userId, String movieId);

	public MovieReview createMovieReview(MovieReview movieReview);

	public MovieReview updateMovieReview(MovieReview movieReview);

	public void deleteMovieReview(MovieReview movieReview);

	public void deleteAllMovieReviewForUser(List<MovieReview> movieReview);

	public void deleteAllMovieReviewForMovie(List<MovieReview> movieReview);

	

}
