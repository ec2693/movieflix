package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Genre;
import io.egen.rest.repository.GenreRepository;

@Service
public class GenreServiceImp implements GenreService {
	
	@Autowired
    GenreRepository repository;

	@Override
	public Genre getGenre(String genreId) {
		return repository.getGenre(genreId);
	}
	
	public List<Genre> getGenreForGenreType(String genreType){
		return repository.getGenreForGenreType(genreType);
	}

	@Override
	@Transactional
	public List<Genre> createGenre(List<Genre> genre) {
		return repository.createGenre(genre);
	}

	@Override
	@Transactional
	public List<Genre> updateGenre(List<Genre> genre) {
		return repository.updateGenre(genre);
	}

	@Override
	@Transactional
	public void deleteGenre(List<Genre> genre) {
		repository.deleteGenre(genre);
		
	}

}
