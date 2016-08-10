package io.egen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.rest.entity.MovieReview;
import io.egen.rest.service.MovieReviewService;

@RestController
@RequestMapping(path = "reviews")
public class MovieReviewController {
	
	@Autowired
	MovieReviewService service;
	
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieReview> getAllReview(){
		return service.getAllReview();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "getReviewsFor/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieReview> getAllReviewForMovie(@PathVariable("movieId") String movieId){
		return service.getAllReviewForMovie(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "getReviewsBy/{userId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MovieReview> getAllReviewByUser(@PathVariable("userId") String userId){
		return service.getAllReviewByUser(userId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "getReviewsFor/{userId}/{movieId}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieReview getReviewByUserForMovie(@PathVariable("userId") String userId,@PathVariable("movieId") String movieId){
		return service.getReviewByUserForMovie(userId,movieId);
	}
	
	
	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieReview createMovieReview(@RequestBody MovieReview movieReview){
		return service.createMovieReview(movieReview);
}
   //CHECK THIS
	@RequestMapping(method = RequestMethod.PUT,path = "{movieReviewId}" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public MovieReview updateMovieReview(@PathVariable("movieReviewId") String movieReviewId, @RequestBody MovieReview movieReview){
		return service.updateMovieReview(movieReviewId,movieReview);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "{movieReviewId}")
	public void deleteMovieReviewById(@PathVariable("movieReviewId") String movieReviewId){
		service.deleteMovieReviewById(movieReviewId);
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, path = "{userId}/{movieId}")
	public void deleteMovieReview(@PathVariable("userId") String userId,@PathVariable("movieId") String movieId){
		service.deleteMovieReview(userId,movieId);
	}
		
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/users/{userId}")
	public void deleteAllMovieReviewForUser(@PathVariable("userId") String userId){
		service.deleteAllMovieReviewForUser(userId);
	}
		
		
	@RequestMapping(method = RequestMethod.DELETE, path = "/movies/{movieId}")
	public void deleteAllMovieReviewForMovie(@PathVariable("movieId") String movieId){
			service.deleteAllMovieReviewForMovie(movieId);
	}
	
	
	
}
	
	
	
	
	
	