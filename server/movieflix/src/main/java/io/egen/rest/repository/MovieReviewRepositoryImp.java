package io.egen.rest.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import io.egen.rest.entity.Movie;
import io.egen.rest.entity.MovieReview;
import io.egen.rest.entity.User;

@Repository
public class MovieReviewRepositoryImp implements MovieReviewRepository{
	
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public MovieReview getMovieReviewById(String movieReviewId) {
		return em.find(MovieReview.class, movieReviewId);
	}
	

	@Override
	public List<MovieReview> getAllReview() {
		TypedQuery<MovieReview> query = em.createNamedQuery("MovieReview.findAll", MovieReview.class);
		return query.getResultList();
	}

	@Override
	public List<MovieReview> getAllReviewForMovie(Movie movie) {
		TypedQuery<MovieReview> query = em.createNamedQuery("MovieReview.findAllReviewForMovie", MovieReview.class);
		query.setParameter("pMovie", movie);
		return query.getResultList();
	}

	@Override
	public List<MovieReview> getAllReviewByUser(User user) {
		TypedQuery<MovieReview> query = em.createNamedQuery("MovieReview.findAllReviewByUser", MovieReview.class);
		query.setParameter("pUser", user);
		return query.getResultList();
	}

	@Override
	public MovieReview getReviewByUserForMovie(User user,Movie movie) {
		TypedQuery<MovieReview> query = em.createNamedQuery("MovieReview.findAReviewForMovieByUser", MovieReview.class);
		query.setParameter("pMovie", movie);
		query.setParameter("pUser", user);
		return query.getSingleResult();
	}

	@Override
	public MovieReview createMovieReview(MovieReview movieReview) {
		em.persist(movieReview);
		return movieReview;
	}

	@Override
	public MovieReview updateMovieReview(MovieReview movieReview) {
		em.merge(movieReview);
		return movieReview;
		
	}

	@Override
	public void deleteMovieReview(MovieReview movieReview) {
			em.remove(movieReview);
	}

	@Override
	public void deleteAllMovieReviewForUser(List<MovieReview> movieReview) {
		for(MovieReview review:movieReview){
			em.remove(review);
		}
	}

	@Override
	public void deleteAllMovieReviewForMovie(List<MovieReview> movieReview) {
		for(MovieReview review:movieReview){
			em.remove(review);
		}
		
	}

	




}
