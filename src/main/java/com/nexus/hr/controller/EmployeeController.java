package com.nexus.hr.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.nexus.hr.dto.EmployeeDTO;
import com.nexus.hr.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// CREATE EMPLOYEE
	@PostMapping
	public EmployeeDTO createEmployee(@Valid @RequestBody EmployeeDTO dto) {
		return employeeService.createEmployee(dto);
	}

	// GET BY ID
	@GetMapping("/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	// GET ALL (NON-PAGINATED)
	@GetMapping
	public List<EmployeeDTO> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	// PAGINATED API
	@GetMapping("/page")
	public Page<EmployeeDTO> getEmployees(Pageable pageable) {
		return employeeService.getEmployees(pageable);
	}

	// UPDATE EMPLOYEE
	@PutMapping("/{id}")
	public EmployeeDTO updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO dto) {
		return employeeService.updateEmployee(id, dto);
	}

	// DELETE EMPLOYEE
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "Employee deleted successfully";
	}
}