package io.egen.rest.service;

import io.egen.rest.entity.Imdb;

public interface ImdbService {
	
      public Imdb getImdb(String imdbId);
      public Imdb createImdb(Imdb imdb);
      public Imdb updateImdb(Imdb imdb);
      public void deleteImdb(Imdb imdb);
      

}
