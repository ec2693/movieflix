package io.egen.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Imdb;
import io.egen.rest.repository.ImdbRepository;

@Service
public class ImdbServiceImp  implements ImdbService{
	
	@Autowired
	ImdbRepository repository;

	@Override
	public Imdb getImdb(String imdbId) {
		return repository.getImdb(imdbId);
		
	}

	@Override
	@Transactional
	public Imdb createImdb(Imdb imdb) {
		return repository.createImdb(imdb);
	}

	@Override
	@Transactional
	public Imdb updateImdb(Imdb imdb) {
		return repository.updateImdb(imdb);
		
	}

	@Override
	@Transactional
	public void deleteImdb(Imdb imdb) {
		repository.deleteImdb(imdb);
		
	}

}
