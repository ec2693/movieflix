package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.rest.entity.MovieReview;

@Repository
public class MovieReviewRepositoryImp implements MovieReviewRepository{
	
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public List<MovieReview> getAllReview() {
		TypedQuery<MovieReview> query = em.createNamedQuery("MovieReview.findAll", MovieReview.class);
		return query.getResultList();
	}

	@Override
	public List<MovieReview> getAllReviewForMovie(String movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieReview> getAllReviewByUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieReview getReviewByUserForMovie(String userId, String movieId) {
		// TODO Auto-generated method stub
		return null;
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
