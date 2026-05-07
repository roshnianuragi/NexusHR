package com.nexus.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexus.hr.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	// find by project name
	List<Project> findByProjectNameContainingIgnoreCase(String projectName);

	// find by status (Active/Completed/etc.)
	List<Project> findByStatus(String status);

	// find by client name
	List<Project> findByClientNameContainingIgnoreCase(String clientName);
}