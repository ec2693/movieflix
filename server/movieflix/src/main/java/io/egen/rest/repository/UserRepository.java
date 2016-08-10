package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.User;

public interface UserRepository {
	
	public List<User> findAllUser();
	
	public User getUser(String userName,String password);
	
	public User getUserByUserName(String userName);
	
	public User getUserByUserId(String userId);
	
	public User createUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUser(User user);
	

}
