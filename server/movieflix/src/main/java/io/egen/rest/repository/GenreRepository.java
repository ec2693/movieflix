package io.egen.rest.repository;

import java.util.List;
import io.egen.rest.entity.Genre;

public interface GenreRepository {
	
	public Genre getGenre(String genreId);
	
	public List<Genre> getGenreForGenreType(String genreType);   
	
	public List<Genre> createGenre(List<Genre> genre);
	
	public List<Genre> updateGenre(List<Genre> genre);
	
	public void deleteGenre(List<Genre> genre);

	  

}
