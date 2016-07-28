package io.egen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.rest.entity.Cast;
import io.egen.rest.service.CastService;

@RestController
@RequestMapping(path = "casts")
public class CastController {
	
	
//	@Autowired
//	CastService service;
//	
//	@RequestMapping(method = RequestMethod.GET,path = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public List<Cast> getCast (@PathVariable("id") String castId){
//		return service.getCast(castId);
//	}
//	
//	@RequestMapping(method = RequestMethod.POST ,path = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public Cast createCast(@RequestBody Cast cast){
//		return service.createCast(cast);
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT ,path = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public Cast updateCast(@PathVariable("id") String castId, @RequestBody Cast cast){
//		return service.updateCast(castId, cast);
//	}
//	
//	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
//	public void deleteCast(@PathVariable("id") String castId){
//		service.deleteCast(castId);
//	}
//	
//	

}
