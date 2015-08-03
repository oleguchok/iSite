package com.oguchok.isite.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguchok.isite.persistence.model.User;
import com.oguchok.isite.persistence.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer>{
	
	VerificationToken findByToken(String token);
	 
    VerificationToken findByUser(User user);
}
