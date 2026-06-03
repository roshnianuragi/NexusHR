package com.nexus.hr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.ProjectDTO;
import com.nexus.hr.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	private final ProjectService service;

	public ProjectController(ProjectService service) {
		this.service = service;
	}

	// CREATE PROJECT
	@PostMapping
	public ProjectDTO create(@Valid @RequestBody ProjectDTO dto) {

		return service.create(dto);
	}

	// GET BY ID
	@GetMapping("/{id}")
	public ProjectDTO getById(@PathVariable Long id) {

		return service.getById(id);
	}

	// GET ALL
	@GetMapping
	public List<ProjectDTO> getAll() {

		return service.getAll();
	}

	// UPDATE
	@PutMapping("/{id}")
	public ProjectDTO update(@PathVariable Long id, @Valid @RequestBody ProjectDTO dto) {

		return service.update(id, dto);
	}

	// DELETE
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {

		service.delete(id);

		return "Project deleted successfully";
	}

	// ASSIGN EMPLOYEES
	@PostMapping("/{projectId}/assign")
	public String assignEmployees(

			@PathVariable Long projectId,

			@RequestBody List<Long> employeeIds) {

		service.assignEmployees(projectId, employeeIds);

		return "Employees assigned successfully";
	}

	// REMOVE EMPLOYEE
	@DeleteMapping("/{projectId}/employees/{employeeId}")
	public String removeEmployee(

			@PathVariable Long projectId,

			@PathVariable Long employeeId) {

		service.removeEmployee(projectId, employeeId);

		return "Employee removed from project";
	}
}