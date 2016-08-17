package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.rest.entity.User;

@Repository
public class UserRepositoryImp  implements UserRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAllUser(){
		TypedQuery<User> query = em.createNamedQuery("User.findAllUser", User.class);
		query.setParameter("pRole", "USER");
		return query.getResultList();
		
	}

	@Override
	public User getUser(String userName, String password) {
		TypedQuery<User> query = em.createNamedQuery("User.find", User.class);
		query.setParameter("pUserName", userName);
		query.setParameter("pPassword", password);
		return query.getSingleResult();
		
	}
	
	@Override
	public User getAdmin(String adminUserName, String password) {
		TypedQuery<User> query = em.createNamedQuery("Admin.find", User.class);
		query.setParameter("pUserName", adminUserName);
		query.setParameter("pPassword", password);
		return query.getSingleResult();
	}


	@Override
	public User getUserByUserName(String userName) {
		TypedQuery<User> query = em.createNamedQuery("User.findUserByUserName", User.class);
		query.setParameter("pUserName", userName);
		return query.getSingleResult();
	}

	@Override
	public User getUserByUserId(String userId) {
		return em.find(User.class, userId);
	}

	@Override
	public User createUser(User user) {
		user.setRole("USER");
		 em.persist(user);
		 return user;
		
	}

	@Override
	public User updateUser(User user) {
		 em.merge(user);
		 return user;
	}

	@Override
	public void deleteUser(User user) {
		em.remove(user);
		
	}

	
}
