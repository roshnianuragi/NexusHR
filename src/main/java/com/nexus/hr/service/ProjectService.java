package com.nexus.hr.service;

import java.util.List;

import com.nexus.hr.dto.ProjectDTO;

public interface ProjectService {

	// CREATE
	ProjectDTO create(ProjectDTO dto);

	// GET BY ID
	ProjectDTO getById(Long id);

	// GET ALL
	List<ProjectDTO> getAll();

	// UPDATE
	ProjectDTO update(Long id, ProjectDTO dto);

	// DELETE
	void delete(Long id);

	// ASSIGN EMPLOYEES TO PROJECT
	void assignEmployees(Long projectId, List<Long> employeeIds);

	// REMOVE EMPLOYEE FROM PROJECT
	void removeEmployee(Long projectId, Long employeeId);
}