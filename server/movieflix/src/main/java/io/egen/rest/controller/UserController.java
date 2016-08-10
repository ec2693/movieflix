package io.egen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.egen.rest.entity.User;
import io.egen.rest.service.UserService;

@RestController
@RequestMapping(path = "users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll(){
		return service.findAllUser();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{userName}/{password}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User getUser(@PathVariable("userName")String userName, @PathVariable("password") String password){
		return service.getUser(userName, password);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "auth",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public boolean authUser(@RequestBody User user){
		return service.authUser(user);
	}
	
	
	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User createUser(@RequestBody User user){
		return service.createUser(user);	
	}
	
	@RequestMapping(method = RequestMethod.PUT,path = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User updateUser( @PathVariable("id") String userId ,@RequestBody User user){
		return service.updateUser(userId, user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,path = "{id}")
	public void deleteUser(@PathVariable("id") String userId){
		service.deleteUser(userId);
	}
	
}
