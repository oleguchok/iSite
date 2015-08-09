package com.oguchok.isite.persistence.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oguchok.isite.persistence.model.Project;
import com.oguchok.isite.persistence.repository.ProjectRepository;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public List<Project> getProjectsByUserId(int id) {
		
		List<Project> projects = projectRepository.findByUserId(id);
		return projects;
	}

	@Override
	public void saveProject(Project project) {
		
		projectRepository.save(project);
	}

	@Override
	public Project getProjectByName(String projectName) {
		
		return projectRepository.findByProjectName(projectName);
	}

	@Override
	public void deleteProject(Project project) {

		projectRepository.delete(project);		
	}

}
