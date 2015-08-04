package com.oguchok.isite.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oguchok.isite.persistence.model.Project;
import com.oguchok.isite.persistence.model.User;
import com.oguchok.isite.persistence.service.ProjectService;
import com.oguchok.isite.persistence.service.UserService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public ModelAndView getMyProjects(HttpServletRequest request) {
	
		User user  = userService.getUserByName(request.getUserPrincipal().getName());
		ModelAndView model = new ModelAndView();
		List<Project> projects = projectService.getProjectsByUserId(user.getId());
		model.addObject("projects", projects);
		model.setViewName("projects");
		return model;
	}
}
