package com.oguchok.isite.persistence.service;

import java.util.List;

import com.oguchok.isite.persistence.model.Page;

public interface PageService {

	List<Page> getProjectPages(int projectId);
	
	void savePage(Page page);
	
	Page getProjectPage(int projectId, int pageNumber);
	
	int getNumberOfPagesInProject(int projectId);
}
