package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Cast;
import io.egen.rest.exception.MovieDoesNotExistsException;
import io.egen.rest.repository.CastRepository;

@Service
public class CastServiceImp implements CastService {
    
    @Autowired
    CastRepository repository;
    
	@Override
	public Cast getCast(String castId) {
		 Cast existing = repository.getCast(castId);
		  if(existing == null){
			throw new MovieDoesNotExistsException("Cast Does Not Exists");
		}
		return existing;
	}

	@Override
	@Transactional
	public List<Cast> createCast(List<Cast> cast) {
		return repository.createCast(cast);
	}

	@Override
	@Transactional
	public List<Cast> updateCast(List<Cast> cast) {
		return repository.updateCast(cast);
		

	}
	@Override
	@Transactional
	public void deleteCast(List<Cast> cast) {
		repository.deleteCast(cast);
	}

}
