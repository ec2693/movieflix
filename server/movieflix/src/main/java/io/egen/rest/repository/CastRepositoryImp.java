package io.egen.rest.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import io.egen.rest.entity.Cast;

@Repository
public class CastRepositoryImp implements CastRepository {
    
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Cast getCast(String castId) {
		return em.find(Cast.class, castId);
		
	}

	@Override
	public List<Cast> createCast(List<Cast> cast) {
		for(Cast casts: cast){
			em.persist(casts);
		}
		return cast;
	}

	@Override
	public List<Cast> updateCast(List<Cast> cast) {
		for(Cast casts: cast){
			em.merge(casts);
		}
		return cast;
	}
	

	@Override
	public void deleteCast(List<Cast> cast) {
		for(Cast casts: cast){
			em.remove(casts);
		}
	}

}
