package com.oguchok.isite.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguchok.isite.persistence.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

	Project findByUserId(int id);
}
