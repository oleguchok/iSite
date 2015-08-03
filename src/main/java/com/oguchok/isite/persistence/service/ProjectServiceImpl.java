package com.oguchok.isite.persistence.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oguchok.isite.persistence.model.Project;
import com.oguchok.isite.persistence.repository.ProjectRepository;

public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public List<Project> getProjectsByUserId(int id) {
		
		Project project = projectRepository.findByUserId(id);
		List<Project> projects = new ArrayList<Project>();
		projects.add(project);
		return projects;
	}

}
