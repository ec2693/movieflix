package io.egen.rest.repository;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.rest.entity.Movie;

@Repository
public class MovieRepositoryImp implements MovieRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}
	
	@Override
	public Movie findById(String movieId) {
		return em.find(Movie.class, movieId);
		
	}

	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies = query.getResultList();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		}
		 return null;
		}
		

	@Override
	public List<Movie> findAllByType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAllByType", Movie.class);
		query.setParameter("pType", type);
		return query.getResultList();
	}

	@Override
	public List<Movie> findAllByYear(int year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAllByYear", Movie.class);
		query.setParameter("pYear", year);
		return query.getResultList();
	}
	
	@Override
	public List<Movie> findAllByGenre(String  genreType) {
	  TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m JOIN m.genre g WHERE g.genreType = :pGenreType",Movie.class);
	  query.setParameter("pGenreType", genreType);
		return query.getResultList();
	}
	
	@Override
	public List<Movie> findAllByTypeAndGenre(String type, String genreType) {
		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m JOIN m.genre g WHERE m.type =:pType AND g.genreType = :pGenreType",Movie.class);
		 query.setParameter("pType", type);
		 query.setParameter("pGenreType", genreType);
			return query.getResultList();
		
	}

	@Override
	public List<Movie> sortAllByYear() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortAllByYear", Movie.class);
		return query.getResultList();
		
	}
	
	@Override
	public List<Movie> sortAllByTypeAndYear(String type) {
		TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.type =:pType ORDER BY m.year DESC",Movie.class);
		 query.setParameter("pType", type);
			return query.getResultList();
	}


	@Override
	public Movie createMovie(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		 em.merge(movie);
		 return movie;
	}

	@Override
	public void deleteMovie(Movie movie) {
		em.remove(movie);
		
		
	}

	
	
	
	

	

}
