package com.oguchok.isite.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public ModelAndView registerUserAccount
	      (@RequestBody String html, BindingResult result,
                  Model model) {
		return null;
	}
}
