package com.oguchok.isite.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oguchok.isite.persistence.model.Project;
import com.oguchok.isite.persistence.model.User;
import com.oguchok.isite.persistence.service.ProjectService;
import com.oguchok.isite.persistence.service.UserService;

@Controller
@RequestMapping(value = "/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	User getCurrentUser(HttpServletRequest request){
        
        return userService.getUserByName(request.getUserPrincipal().getName());
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMyProjects(HttpServletRequest request) {
	
		ModelAndView model = new ModelAndView("projects");
		model.addObject("projects", getCurrentUser(request).getProjects());
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddProjectPage(Model model) {
		
		Project project = new Project();
		model.addAttribute("project", project);
		return "add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addProject(@ModelAttribute("project") Project project,
			HttpServletRequest request) {
		
		User user  = getCurrentUser(request);
		project.setUser(user);
		projectService.saveProject(project);
		ModelAndView model = new ModelAndView("projects");
		model.addObject("projects", projectService.getProjectsByUserId(user.getId()));
		return model;		
	}
}
