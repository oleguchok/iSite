package com.oguchok.isite.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguchok.isite.persistence.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	public Role findByName(String name);
	
}
