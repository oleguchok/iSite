package com.oguchok.isite.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
	private MessageSource messages;
	
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
		
		ModelAndView model = new ModelAndView("projects");
		if (isProjectExist(project.getProjectName())){
			
			model.addObject("error", messages.getMessage("message.existError",
	    			null, LocaleContextHolder.getLocale()));
			model.setViewName("add");
			return model.addObject("project", project);
		} else {
		
			User user  = getCurrentUser(request);
			project.setUser(user);
			projectService.saveProject(project);
			model.addObject("projects", projectService.getProjectsByUserId(user.getId()));
			return model;
		}
	}
	
	private boolean isProjectExist(String projectName) {
		
		Project project = projectService.getProjectByName(projectName);
		if (project == null) {
			return false;
		} else {
			return true;
		}
		
	}
}
