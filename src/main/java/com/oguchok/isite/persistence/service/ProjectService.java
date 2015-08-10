package com.oguchok.isite.persistence.service;

import java.util.List;

import com.oguchok.isite.persistence.model.Project;

public interface ProjectService {

	List<Project> getProjectsByUserId(int id);
	
	void saveProject(Project project);
	
	Project getProjectByName(String projectName);
	
	void deleteProject(Project project);
	
	List<Project> getAllProjects();
}
