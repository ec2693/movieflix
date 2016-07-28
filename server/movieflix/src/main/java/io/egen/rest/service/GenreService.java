package io.egen.rest.service;

import java.util.List;
import io.egen.rest.entity.Genre;

public interface GenreService {
	
    public Genre getGenre(String genreId);
	
	public List<Genre> createGenre(List<Genre> genre);
	
	public List<Genre> updateGenre(List<Genre> genre);
	
	public void deleteGenre(List<Genre> genre);

}
