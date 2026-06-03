package com.nexus.hr.controller;

import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.EmployeeProfileDTO;
import com.nexus.hr.service.EmployeeProfileService;

@RestController
@RequestMapping("/api/employee-profile")
public class EmployeeProfileController {

	private final EmployeeProfileService service;

	public EmployeeProfileController(EmployeeProfileService service) {
		this.service = service;
	}

	// CREATE OR UPDATE PROFILE
	@PostMapping
	public EmployeeProfileDTO createOrUpdate(@RequestBody EmployeeProfileDTO dto) {
		return service.createOrUpdate(dto);
	}

	// GET PROFILE BY EMPLOYEE ID
	@GetMapping("/{employeeId}")
	public EmployeeProfileDTO getByEmployeeId(@PathVariable Long employeeId) {
		return service.getByEmployeeId(employeeId);
	}
}