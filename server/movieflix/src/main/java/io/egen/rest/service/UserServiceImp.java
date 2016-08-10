package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.egen.rest.entity.User;
//import io.egen.rest.exception.UserAlreadyExistsException;
import io.egen.rest.exception.UserDoesNotExistsException;
import io.egen.rest.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
     @Autowired
	 UserRepository repository;
     
     @Override
 	public List< User> findAllUser(){
    	 return repository.findAllUser();
     }
     
     @Override
 	public User getUserByUserId(String userId) {
 		return repository.getUserByUserId(userId);
 	}
	 
     @Override
	public User getUser(String userName, String password) {
		User existing = repository.getUser(userName,password);
		if(existing == null){
			throw new UserDoesNotExistsException("User with username"  +userName+"   and password"+password+"  doesn't exixts");
		}
		return existing;
	}
     @Override
	public boolean authUser(User user){
    	 User existing = repository.getUser(user.getUserName(),user.getPassword());
    	 if(existing != null){
    		 return true;
    	 }
    	 return false;
    	 
		
	}

	@Override
	@Transactional
	public User createUser(User user) {
//		String userName = user.getUserName();
//		User existing = repository.getUserByUserName(userName);
//		if( existing != null){
//			throw new UserAlreadyExistsException("User with username  "+userName+"  already exists");
//		}
		return repository.createUser(user);
	}

	@Override
	@Transactional
	public User updateUser(String userId, User user) {
		User existing = repository.getUserByUserId(userId);
		if(existing == null){
			throw new UserDoesNotExistsException("User with userId"  +userId+"  doesn't exixts");
		}
		return repository.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(String userId) {
		User existing = repository.getUserByUserId(userId);
		if(existing == null){
			throw new UserDoesNotExistsException("User with userId"  +userId+"  doesn't exixts");
		}
		repository.deleteUser(existing);
		
	}



	

}
