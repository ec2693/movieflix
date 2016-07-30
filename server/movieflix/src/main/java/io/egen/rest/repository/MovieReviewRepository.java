package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Movie;
import io.egen.rest.entity.MovieReview;
import io.egen.rest.entity.User;

public interface MovieReviewRepository {
	
	public MovieReview getMovieReviewById(String movieReviewId);
	
	public List<MovieReview> getAllReview();

	public List<MovieReview> getAllReviewForMovie(Movie movie);

	public List<MovieReview> getAllReviewByUser(User user);

	public MovieReview getReviewByUserForMovie(User user, Movie movie);

	public MovieReview createMovieReview(MovieReview movieReview);

	public MovieReview updateMovieReview(MovieReview movieReview);

	public void deleteMovieReview(MovieReview movieReview);

	public void deleteAllMovieReviewForUser(List<MovieReview> movieReview);

	public void deleteAllMovieReviewForMovie(List<MovieReview> movieReview);

	

}
