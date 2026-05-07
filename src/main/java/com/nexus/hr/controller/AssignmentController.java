package com.nexus.hr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.AssignmentDTO;
import com.nexus.hr.service.AssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

	private final AssignmentService service;

	public AssignmentController(AssignmentService service) {
		this.service = service;
	}

	// ASSIGN EMPLOYEE TO PROJECT
	@PostMapping
	public AssignmentDTO assignEmployee(@RequestBody AssignmentDTO dto) {
		return service.assignEmployee(dto);
	}

	// GET ALL ASSIGNMENTS
	@GetMapping
	public List<AssignmentDTO> getAll() {
		return service.getAll();
	}

	// REMOVE ASSIGNMENT
	@DeleteMapping("/{id}")
	public String remove(@PathVariable Long id) {
		service.remove(id);
		return "Assignment removed successfully";
	}
}