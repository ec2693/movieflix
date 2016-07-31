package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.rest.entity.Genre;

@Repository
public class GenreRepositoryImp  implements GenreRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Genre getGenre(String genreId) {
		return em.find(Genre.class, genreId);
	}
	
	@Override
	public List<Genre> getGenreForGenreType(String genreType) {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.getAllGenreForGenreType", Genre.class);
		query.setParameter("pGenreType", genreType);
		List<Genre> list = query.getResultList();
		return list;
	}

	@Override
	public List<Genre> createGenre(List<Genre> genre) {
		for(Genre genres: genre){
			em.persist(genres);
		}
		return genre;
	
	}

	@Override
	public List<Genre> updateGenre(List<Genre> genre) {
		for(Genre genres: genre){
			em.merge(genres);
		}
		return genre;
	}

	@Override
	public void deleteGenre(List<Genre> genre) {
		for(Genre genres: genre){
			em.remove(genres);
		}
	}

	

}
