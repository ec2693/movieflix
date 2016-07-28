package io.egen.rest.service;

import io.egen.rest.entity.User;

public interface UserService {

	public User getUser(String userName,String password);
	
	public User createUser(User user);
	
	public User updateUser(String userId,User user);
	
	public  void deleteUser(String userId);
}
