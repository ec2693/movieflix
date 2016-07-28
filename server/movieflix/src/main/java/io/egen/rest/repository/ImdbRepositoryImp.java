package io.egen.rest.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.egen.rest.entity.Imdb;

@Repository
public class ImdbRepositoryImp  implements ImdbRepository{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Imdb getImdb(String imdbId) {
		return em.find(Imdb.class, imdbId);
		
	}

	@Override
	public Imdb createImdb(Imdb imdb) {
		em.persist(imdb);
		return imdb;
	}

	@Override
	public Imdb updateImdb(Imdb imdb) {
		return em.merge(imdb);
		
	}

	@Override
	public void deleteImdb(Imdb imdb) {
		em.remove(imdb);
		
	}

}
