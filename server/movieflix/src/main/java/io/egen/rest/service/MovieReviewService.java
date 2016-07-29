package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.MovieReview;

public interface MovieReviewService {
	
	  public List<MovieReview> getAllReview();
	
      public List<MovieReview> getAllReviewForMovie(String movieId);

      public List<MovieReview> getAllReviewByUser(String userId);
      
      public MovieReview getReviewByUserForMovie(String userId, String movieId);

      public MovieReview createMovieReview(MovieReview movieReview);

      public MovieReview updateMovieReview(String userId,String movieId,MovieReview movieReview);

	  public void deleteMovieReview(String userId, String movieId);
 
	  public void deleteAllMovieReviewForUser(String userId);
	
	  public void deleteAllMovieReviewForMovie(String movieId);


}
