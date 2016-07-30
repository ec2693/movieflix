package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.User;

public interface UserService {
	
	public List<User> findAllUser();
	
	public User getUserByUserId(String userId);

	public User getUser(String userName,String password);
	
	public boolean authUser(User user);
	
	public User createUser(User user);
	
	public User updateUser(String userId,User user);
	
	public  void deleteUser(String userId);
}
