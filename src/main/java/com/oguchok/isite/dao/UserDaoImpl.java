package com.oguchok.isite.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.oguchok.isite.models.User;

@Repository
public class UserDaoImpl implements UserDao{

//	@Autowired
//	private SessionFactory sessionFactory;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {
		
		return (User)entityManager
				.createQuery("SELECT u FROM User u WHERE u.username = :username")
				.setParameter("username", username)
				.getSingleResult();
	}

}
