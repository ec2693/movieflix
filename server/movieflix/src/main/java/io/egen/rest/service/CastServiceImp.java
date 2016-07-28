package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.rest.entity.Cast;
import io.egen.rest.entity.Movie;
import io.egen.rest.exception.MovieDoesNotExistsException;
import io.egen.rest.repository.CastRepository;
import io.egen.rest.repository.MovieRepository;

@Service
public class CastServiceImp implements CastService {
    
    @Autowired
    CastRepository cRepository;
    
	@Override
	public List<Cast> getCast(String castId) {
		List<Cast> existing = cRepository.getCast(castId);
		if(existing == null){
			throw new MovieDoesNotExistsException("Cast Does Not Exists");
		}
		return existing;
	}

	@Override
	public List<Cast> createCast(List<Cast> cast) {
		return cRepository.createCast(cast);
	}

	@Override
	public List<Cast> updateCast(List<Cast> cast) {
			return cRepository.updateCast(cast);
		}


//	@Override
//	public void deleteCast(String movieId) {
//		Movie existing = mRepository.findById(movieId);
//		if(existing == null){
//			throw new MovieDoesNotExistsException("Movie Does Not Exists");
//		}
//		cRepository.deleteCast(movieId);
//	}

}
