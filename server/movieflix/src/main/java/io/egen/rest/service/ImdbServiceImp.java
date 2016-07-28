package io.egen.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public Imdb createImdb(Imdb imdb) {
		return repository.createImdb(imdb);
	}

	@Override
	public Imdb updateImdb(Imdb imdb) {
		return repository.updateImdb(imdb);
		
	}

	@Override
	public void deleteImdb(Imdb imdb) {
		repository.deleteImdb(imdb);
		
	}

}
