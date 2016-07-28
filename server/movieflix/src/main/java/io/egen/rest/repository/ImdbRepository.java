package io.egen.rest.repository;

import io.egen.rest.entity.Imdb;

public interface ImdbRepository {
	
	public Imdb getImdb(String imdbId);
    
    public Imdb createImdb(Imdb imdb);
    
    public Imdb updateImdb(Imdb imdb);
    
    public void deleteImdb(Imdb imdb);

}
