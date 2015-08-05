package com.oguchok.isite.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguchok.isite.persistence.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

	List<Project> findByUserId(int id);
	
	Project findByProjectName(String projectName);
}
