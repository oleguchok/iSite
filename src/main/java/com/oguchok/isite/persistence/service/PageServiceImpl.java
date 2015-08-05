package com.oguchok.isite.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oguchok.isite.persistence.model.Page;
import com.oguchok.isite.persistence.repository.PageRepository;

@Service
@Transactional
public class PageServiceImpl implements PageService{

	@Autowired
	private PageRepository pageRepository;
	
	@Override
	public List<Page> getProjectPages(int projectId) {
		
		return pageRepository.findByProjectId(projectId);
	}

	@Override
	public void savePage(Page page) {
		
		pageRepository.save(page);
	}

}
