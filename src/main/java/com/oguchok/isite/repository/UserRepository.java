package com.oguchok.isite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguchok.isite.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);
	
	User findByEmail(String email);
}
