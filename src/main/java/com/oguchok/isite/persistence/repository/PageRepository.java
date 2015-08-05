package com.oguchok.isite.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguchok.isite.persistence.model.Page;

public interface PageRepository extends JpaRepository<Page, Integer>{

	List<Page> findByProjectId(int projectId);
}
