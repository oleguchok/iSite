package com.oguchok.isite.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.oguchok.isite.config.AppConfig;
import com.oguchok.isite.config.JpaConfig;
import com.oguchok.isite.config.WebConfig;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { JpaConfig.class, AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
}