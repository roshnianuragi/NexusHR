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

	// UPDATE PROJECT
	@PutMapping("/{id}")
	public ProjectDTO update(@PathVariable Long id, @Valid @RequestBody ProjectDTO dto) {
		return service.update(id, dto);
	}

	// DELETE PROJECT
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "Project deleted successfully";
	}
}