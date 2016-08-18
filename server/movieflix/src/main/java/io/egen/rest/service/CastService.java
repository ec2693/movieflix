package io.egen.rest.service;

import java.util.List;


import io.egen.rest.entity.Cast;

public interface CastService {
	
	public Cast getCast(String castId);
	public List<Cast> createCast(List<Cast> cast);
	public List<Cast> updateCast(List<Cast> cast);
	public void deleteCast(List<Cast> cast);

	
	
	

}
