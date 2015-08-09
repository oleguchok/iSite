package com.oguchok.isite.web.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.oguchok.isite.persistence.model.Page;
import com.oguchok.isite.persistence.model.Project;
import com.oguchok.isite.persistence.model.User;
import com.oguchok.isite.persistence.service.PageService;
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
	
	@Autowired
	private PageService pageService;
	
	User getCurrentUser(HttpServletRequest request){
        
        return userService.getUserByName(request.getUserPrincipal().getName());
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getMyProjects(HttpServletRequest request) {
	
		ModelAndView model = new ModelAndView("projects");
		model.addObject("projects", getCurrentUser(request).getProjects());
		return model;
	}
	
	@RequestMapping(value = "/{projectName}/delete", method = RequestMethod.GET)
	public ModelAndView deleteProject(@PathVariable String projectName, 
			HttpServletRequest request) {
	
		ModelAndView model = new ModelAndView(new RedirectView("projects"));
		projectService.deleteProject(projectService.getProjectByName(projectName));
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
	
	@RequestMapping(value = "/edit/{projectName}/{pageNumber}", method = RequestMethod.GET)
	public String getEditProjectPage(@PathVariable String projectName,
			@PathVariable int pageNumber, Model model) {
		
		Project project = projectService.getProjectByName(projectName);
		model.addAttribute("projectName", projectName);
		model.addAttribute("page", pageService.getProjectPage(project.getId(), pageNumber));
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("project", project);
		return "pageEditor";
	}
	
	@RequestMapping(value = "/edit/{projectName}/{pageNumber}", method = RequestMethod.POST)
	public String registerUserAccount
	      (@RequestBody String html, BindingResult result, @PathVariable String projectName,
	    		  @PathVariable int pageNumber, Model model) throws UnsupportedEncodingException {
		
		Page page = new Page();
		Project project = projectService.getProjectByName(projectName);
		html = html.substring(0, html.length() - 43);
		page.setHtml(java.net.URLDecoder.decode(html, "UTF-8").substring(5));
		page.setNumber(pageNumber);
		page.setProject(project);
		page.setMenu("Page " + Integer.toString(pageNumber));
		pageService.savePage(page);
		setPageModel(model,projectName,pageNumber, true);
		model.addAttribute("project", project);
		model.addAttribute("content", page.getHtml());
		model.addAttribute("style", setBootstrapStyleForProject(project));
		model.addAttribute("pages", pageService.getProjectPages(project.getId()));
		return "page";
	}
	
	@RequestMapping(value = "/add/{projectName}", method = RequestMethod.GET)
	public String addPageToProject(@PathVariable String projectName,
			Model model) {
		
		Project project = projectService.getProjectByName(projectName);
		int pageNumber = pageService.getNumberOfPagesInProject(project.getId()) + 1;
		model.addAttribute("projectName", projectName);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("project", project);
		return "pageEditor";
	}
	
	@RequestMapping(value = "/{projectName}/{pageNumber}", method = RequestMethod.GET)
	public String getProjectPage(@PathVariable String projectName,
			@PathVariable int pageNumber, Model model, HttpServletRequest request){
		
		Project project = projectService.getProjectByName(projectName);
		if (pageNumber == 0) {
			
			pageNumber = pageService.getNumberOfPagesInProject(project.getId());
		}
		
		boolean isUserPage = isUserPage(project, request);	
		setPageModel(model,projectName,pageNumber,isUserPage);	
		model.addAttribute("project", project);
		Page page = pageService.getProjectPage(project.getId(), pageNumber);
		if (page == null && isUserPage) {
			
			return "pageEditor";
		}
		model.addAttribute("content", page.getHtml());
		model.addAttribute("style", setBootstrapStyleForProject(project));
		model.addAttribute("pages", pageService.getProjectPages(project.getId()));
		return "page";
	}

	@RequestMapping(value = "/{projectName}/menu", method = RequestMethod.GET)
	public String getProjectMenu(@PathVariable String projectName, Model model) {
		
		
		return "menu";
	}
	
	private void setPageModel(Model model, String projectName, int pageNumber,
			boolean isUserPage) {
		
		model.addAttribute("projectName", projectName);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("isUserPage", isUserPage);
		
	}
	
	private String setBootstrapStyleForProject(Project project){
		
		if (project.getStyle().equals("light")){
			return "bootstrap-light.min.css";
		}
		else {
			return "bootstrap.min.css";
		}
	}
	
	private boolean isUserPage(Project project, HttpServletRequest request) {
		
		boolean isUserPage = false;
		if (project.getUser().getUsername().equals(getCurrentUser(request).getUsername())) {
			
			isUserPage = true;
		}
		return isUserPage;
	}
}
